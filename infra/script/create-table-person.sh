#!/bin/bash

aws dynamodb --endpoint-url=http://localhost:4566 create-table \
    --table-name persons \
    --attribute-definitions \
        AttributeName=cpf,AttributeType=S \
    --key-schema \
        AttributeName=cpf,KeyType=HASH \
--provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5



aws dynamodb --endpoint-url=http://localhost:4566 create-table \
    --table-name addresses \
    --attribute-definitions \
        AttributeName=cpf,AttributeType=S \
    --key-schema \
        AttributeName=cpf,KeyType=HASH \
--provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5



aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name queue-log

aws --endpoint-url=http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/queue/queue-log --max-number-of-messages 10