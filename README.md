# Howler Client Library

The Howler client library facilitates issuing requests to Howler.

## Running the Tests

1. Prepare the howler-api:
    1. Start dependencies
    1. `howler-api > python howler/app.py`
    1. `howler-api > python howler/odm/random_data.py`
3. Run python integration tests:
    1. `python -m venv env`
    1. `. env/bin/activate`
    1. `pip install -r requirements.txt`
    1. `pip install -r test/requirements.txt`
    1. `pip install -e .`
    1. `pytest -s -v test`
    
