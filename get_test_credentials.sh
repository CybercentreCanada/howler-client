#!/bin/bash

echo "This script allows you to set environment variables before running the Howler Client integration tests."
echo "This will allow the test to connect to your local howler client using either OBO Authentication, or"
echo "a user/API key pair."
echo ""

while [ true ]; do
    echo -n "Do you want to use OBO Authentication? If not, a user/apikey pair will be used instead. (y/n) "
    read yn
    case $yn in
    [Yy]*)
        if [ -z $SPELLBOOK_SECRET ]; then
            echo "SPELLBOOK_SECRET must be set!"
            break
        fi

        data=$(curl -s -d 'client_id=spellbook' \
            -d "client_secret="$SPELLBOOK_SECRET \
            -d 'username=goose' \
            -d 'password=goose' \
            -d 'grant_type=password' \
            'http://localhost:9100/realms/HogwartsMini/protocol/openid-connect/token')

        refresh_token=$(echo $data | python3 -c "import sys, json; print(json.load(sys.stdin)['refresh_token'])")

        export VAULT_REFRESH_TOKEN="spellbook/spellbook:"$refresh_token
        export VAULT_URL="http://localhost:8200"

        echo "VAULT_REFRESH_TOKEN set. Your tests will be run using OBO authentication."
        break
        ;;
    [Nn]*)
        export HOWLER_USERNAME="user"
        export HOWLER_API_KEY="devkey:user"

        echo "HOWLER_USERNAME and HOWLER_API_KEY set. Your tests will be run using API key authentication."
        break
        ;;
    *) echo "\nPlease answer yes or no.\n" ;;
    esac
done
