# Howler Client Library

The Howler client library facilitates issuing requests to Howler.

## Running the Tests

1. Prepare the howler-api:
    1. Start dependencies
    1. `howler-api > python howler/app.py`
    1. `howler-api > python howler/odm/random_data.py`
    1. `howler-api > python howler/odm/random_hits.py`
2. Run Java integration tests:
    1. `howler-client > mvn verify`
3. Run python integration tests:
    1. `howler-client/python > python -m venv env`
    1. `howler-client/python > . env/bin/activate`
    1. `howler-client/python > pip install -r requirements.txt`
    1. `howler-client/python > pip install -r test/requirements.txt`
    1. `howler-client/python > pip install -e .`
    1. `howler-client/python > pytest -s -v test`
