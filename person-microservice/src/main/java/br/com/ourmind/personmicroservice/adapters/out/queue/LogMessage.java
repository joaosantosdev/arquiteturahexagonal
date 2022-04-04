package br.com.ourmind.personmicroservice.adapters.out.queue;

import br.com.ourmind.personmicroservice.domain.models.Person;

public class LogMessage {
    private String message;
    private Person person;

    public LogMessage(String message, Person person) {
        this.message = message;
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public Person getPerson() {
        return person;
    }
}
