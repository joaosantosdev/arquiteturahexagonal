package br.com.ourmind.personmicroservice.domain.ports.in;

import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonDTO;
import br.com.ourmind.personmicroservice.domain.models.Person;

public interface PersonServicePort {
    void save(Person person);

    void update(String cpf, Person map);

    PersonDTO get(String cpf);

    void delete(String cpf);
}
