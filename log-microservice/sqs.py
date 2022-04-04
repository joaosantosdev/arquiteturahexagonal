import time

class SQSClient:
    queue = None
    consumers = []

    def __init__(self, queue):
        self.queue = queue

    def run(self):
        print("Running SQS Consumer\n")
        while True:
            for message in self.queue.receive_messages():
                for method in self.consumers:
                    method(message)
            time.sleep(5)

    def add_consumer(self, method):
        self.consumers.append(method)