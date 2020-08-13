#!/bin/bash
set -euo pipefail

NOTIFICATION_ENDPOINT= $$NOTIFICATION_ENDPOINT
CHAT_WEBHOOK= $$CHAT_WEBHOOK
THREAD_KEY= $(git rev-parse HEAD)

WEBHOOK_URL=$CHAT_WEBHOOK
echo $THREAD_KEY
echo $CHAT_WEBHOOK
echo $NOTIFICATION_ENDPOINT

curl -v -X POST                             \
     -H "Content-Type: application/json" \
     --data $'{"text": "test"}'                   \
     'https://chat.googleapis.com/v1/spaces/24eNZgAAAAE/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=JZusdtqi-qpZCE-R2fGKsBNHekbESV6Oul9sB7TQBGQ%3D'
