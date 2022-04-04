package br.com.ourmind.personmicroservice.adapters.out.queue;

import br.com.ourmind.personmicroservice.adapters.out.queue.sqs.SQSService;
import br.com.ourmind.personmicroservice.domain.models.Person;
import br.com.ourmind.personmicroservice.domain.ports.out.QueueServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService implements QueueServicePort {

    @Autowired
    private SQSService sqsService;
    private static final String QUEUE_NAME = "queue-log";

    @Override
    public void sendMessage(String message, Person person) {
        sqsService.send(QUEUE_NAME, new LogMessage(message, person));
    }
}
