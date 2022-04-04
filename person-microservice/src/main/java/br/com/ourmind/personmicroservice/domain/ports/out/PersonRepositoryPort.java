package br.com.ourmind.personmicroservice.domain.ports.out;

import br.com.ourmind.personmicroservice.domain.models.Person;

public interface PersonRepositoryPort {
    void save(Person person);
    void delete(Person person);
    void update(Person person);
    Person get(String id);
}
