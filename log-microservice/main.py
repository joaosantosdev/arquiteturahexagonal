import boto3
from app_constants import QUEUE_NAME, SQS_ENDPOINT
from sqs import SQSClient
import json

sqs = boto3.resource('sqs', endpoint_url=SQS_ENDPOINT)
queue = sqs.get_queue_by_name(QueueName=QUEUE_NAME)

def consumer(message):
    data = json.loads(message.body)
    print("Dados recebidos...", data)
    message.delete()

sqs = SQSClient(queue)
sqs.add_consumer(consumer)
sqs.run()

