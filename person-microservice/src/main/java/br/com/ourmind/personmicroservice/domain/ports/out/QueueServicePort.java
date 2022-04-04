package br.com.ourmind.personmicroservice.domain.ports.out;

import br.com.ourmind.personmicroservice.domain.models.Person;

public interface QueueServicePort {
        void sendMessage(String message, Person person);
}
