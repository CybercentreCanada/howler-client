import datetime
import os
import time

import pytest

from howler_client.client import Client
from howler_client.common.utils import ClientError
from utils import random_hash

TOOL_NAME = "test"

MAP = {
    "file.sha256": ["file.hash.sha256", "howler.hash"],
    "file.name": ["file.name"],
    "src_ip": ["source.ip", "related.ip"],
    "dest_ip": ["destination.ip", "related.ip"],
    "time.created": ["event.start"],
    "time.completed": ["event.end"],
    "cloud.availability_zone": ["cloud.availability_zone"]
    # TODO: Uncomment this once ignore extra values is permitted
    # "additional_field": ["additional_field"],
}


HITS = [
    {
        "src_ip": "43.228.141.216",
        "dest_ip": "31.46.39.115",
        "file": {
            "name": "cool_file.exe",
            "sha256": random_hash(),
        },
        "time": {
            "created": datetime.datetime(2020, 5, 17).isoformat() + "Z",
            "completed": datetime.datetime(2020, 5, 18).isoformat() + "Z",
        },
        "cloud": {"availability_zone": "deprecated"},
    },
    {
        "src_ip": "248.59.92.198",
        "dest_ip": "148.252.23.152",
        "file": {
            "name": "lame_file.exe",
            "sha256": random_hash(),
        },
        "time": {
            "created": datetime.datetime(2022, 5, 17).isoformat() + "Z",
            "completed": datetime.datetime(2022, 9, 18).isoformat() + "Z",
        }
        # TODO: Uncomment this once ignore extra values is permitted
        # "additional_field": "additional_value",
    },
]


def test_create_from_map(client, caplog):
    res = client.hit.create_from_map(TOOL_NAME, MAP, HITS)

    assert len(res) == len(HITS)
    for hit in res:
        assert "warn" in hit
        assert "error" in hit
        assert "id" in hit
        assert hit["error"] is None
        assert isinstance(hit["id"], str)

    assert all("deprecated" in msg for msg in caplog.messages)


def test_broken_map(client):
    # Test broken map
    broken_map = {
        "file.sha256": ["file.sha256"],
    }

    with pytest.raises(ClientError):
        client.hit.create_from_map(TOOL_NAME, broken_map, HITS)


def test_invalid_data(client):
    invalid_hits = [
        {
            "src_ip": "uh oh",
            "dest_ip": "this data",
            "file": {"name": "doesn't seem", "sha256": "very good"},
            "time": {
                "created": "oh no",
                "completed": "send help",
            },
        }
    ]

    with pytest.raises(ClientError):
        client.hit.create_from_map(TOOL_NAME, MAP, invalid_hits)


def test_deprecated_data(client, caplog):
    deprecated_hits = [
        {
            "src_ip": "248.59.92.198",
            "dest_ip": "148.252.23.152",
            "file": {
                "name": "lame_file.exe",
                "sha256": "abcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890",
            },
            "time": {
                "created": datetime.datetime(2022, 5, 17).isoformat() + "Z",
                "completed": datetime.datetime(2022, 9, 18).isoformat() + "Z",
            },
            "cloud": {"availability_zone": "deprecated"},
        }
    ]

    res = client.hit.create_from_map(TOOL_NAME, MAP, deprecated_hits)

    for hit in res:
        assert len(hit["warn"]) == 1

    assert all("deprecated" in msg for msg in caplog.messages)


def test_create(client):
    res = client.hit.create(
        {
            "howler": {
                "analytic": "A test for creating a hit",
                "score": 0.8,
                "hash": random_hash(),
                "outline": {
                    "threat": "10.0.0.1",
                    "target": "asdf123",
                    "indicators": ["me.ps1"],
                    "summary": "This is a summary",
                },
            },
        }
    )

    assert len(res["valid"]) == 1
    assert len(res["invalid"]) == 0


def test_duplicate(client):
    _random_hash = random_hash()
    client.hit.create(
        {
            "howler.analytic": "test_dupes",
            "howler.score": 0,
            "howler.hash": _random_hash,
        }
    )

    time.sleep(1)

    total = client.search.hit("howler.id:*")["total"]

    client.hit.create(
        [
            {
                "howler.analytic": "test_dupes",
                "howler.score": 0,
                "howler.hash": _random_hash,
            },
            {
                "howler.analytic": "test_dupes",
                "howler.score": 0,
                "howler.hash": random_hash(),
            },
        ]
    )

    time.sleep(1)

    assert client.search.hit("howler.id:*")["total"] == total + 1


def test_create_invalid(caplog, client: Client):
    try:
        client.hit.create(
            [
                {
                    "howler.analytic": "matt-test",
                    "howler.score": 0.8,
                    "howler.outline.threat": "10.0.0.1",
                    "howler.outline.target": "asdf123",
                    "howler.outline.indicators": ["me.ps1"],
                    "howler.outline.summary": "This is a summary",
                },
                {
                    "howler.analytic": "matt-test",
                    # "howler.score": 0.8,
                    "howler.outline.threat": "10.0.0.1",
                    "howler.outline.target": "asdf123",
                    "howler.outline.indicators": ["me.ps1"],
                    "howler.outline.summary": "This is a summary",
                },
            ]
        )
    except ClientError as e:
        assert len(e.api_response["valid"]) == 1
        assert len(e.api_response["invalid"]) == 1
        assert (
            e.api_response["invalid"][0]["error"]
            == "[hit.howler.score]: value is missing from the object!"
        )


def test_delete(client: Client):
    total = client.search.hit("howler.id:*")["total"]

    res = client.hit.create_from_map(TOOL_NAME, MAP, HITS)

    assert client.hit.delete([new_hit["id"] for new_hit in res]) is None

    assert total == client.search.hit("howler.id:*")["total"]


def test_pull_from_assemblyline(client: Client):
    from assemblyline_client import get_client as get_al_client

    user = os.getenv("AL_USER", None)
    apikey = os.getenv("AL_APIKEY", None)

    if not (user and apikey):
        pytest.skip("Assemblyline credentials required to run this test!")

    host = "https://malware-stg.cyber.gc.ca"

    al = get_al_client(host, apikey=(user, apikey))

    al_entries = al.alert.list(fq=["reporting_ts:[now-1M TO now]"], rows=10)
    print(
        f'Total of {al_entries["total"]} items found, showing {len(al_entries["items"])} per page'
    )

    al_hwl_map = {
        "analytic": ["howler.analytic"],
        "org_name": ["organization.name"],
        "framework": ["threat.framework"],
        "tactic_id": ["threat.tactic.id"],
        "tactic_name": ["threat.tactic.name"],
        "scanner_stats": ["threat.indicator.scanner_stats"],
        "file.md5": ["related.hash", "file.hash.md5"],
        "file.sha1": ["related.hash", "file.hash.sha1"],
        "file.sha256": ["related.hash", "file.hash.sha256", "howler.hash"],
        "al.uri_static": ["related.uri"],
        "al.uri_dynamic": ["related.uri"],
        "al.domain_static": ["related.hosts"],
        "al.domain_dynamic": ["related.hosts"],
        "alert_id": ["related.id"],
        "file.name": ["file.name"],
        "file.size": ["file.size"],
        "file.mime_type": ["file.mime_type"],
        "al.detailed.av": ["assemblyline.antivirus"],
        "al.detailed.attrib": ["assemblyline.attribution"],
        "al.detailed.behavior": ["assemblyline.behaviour"],
        "al.detailed.uri": ["assemblyline.uri"],
        "al.detailed.domain": ["assemblyline.domain"],
        "al.detailed.yara": ["assemblyline.yara"],
        "al.detailed.heuristic": ["assemblyline.heuristic"],
        "al.detailed.attack_category": ["assemblyline.mitre.tactic"],
        "al.detailed.attack_pattern": ["assemblyline.mitre.technique"],
    }

    for alert in al_entries["items"]:
        alert["analytic"] = "AssemblyLine"
        alert["org_name"] = alert["metadata"].get("ministerial_authority", "Unknown")
        alert["framework"] = "MITRE ATT&CK"
        alert["tactic_id"] = "TA0001"
        alert["tactic_name"] = "Initial Access"  # TODO: Use howler to populate this
        alert["scanner_stats"] = len(alert["verdict"]["malicious"])

    for alert in al_entries["items"]:
        client.hit.create_from_map("AssemblyLine", al_hwl_map, [alert])
