import pkg_resources

from howler_client.client import Client
from howler_client.connection import Connection

try:
    __version__ = pkg_resources.get_distribution("howler_client").version
except pkg_resources.DistributionNotFound:
    __version__ = "4.0.0.dev0"

RETRY_FOREVER = 0
SUPPORTED_APIS = {"v1"}


def get_client(
    server,
    auth=None,
    cert=None,
    debug=lambda x: None,
    headers=None,
    retries=RETRY_FOREVER,
    silence_requests_warnings=True,
    apikey=None,
    verify=True,
    timeout=None,
    throw_on_bad_request=True,
    throw_on_max_retries=True,
):
    connection = Connection(
        server,
        auth,
        cert,
        debug,
        headers,
        retries,
        silence_requests_warnings,
        apikey,
        verify,
        timeout,
        throw_on_bad_request,
        throw_on_max_retries,
    )
    return Client(connection)
