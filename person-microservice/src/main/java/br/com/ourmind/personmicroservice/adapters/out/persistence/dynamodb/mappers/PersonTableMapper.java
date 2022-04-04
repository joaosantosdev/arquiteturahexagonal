package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.mappers;

import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.PersonTable;
import br.com.ourmind.personmicroservice.domain.models.Person;

public class PersonTableMapper {

    public static PersonTable map(Person person){
        return new PersonTable(
                person.getCpf(),
                person.getName(),
                person.getTimestampCreated(),
                person.getTimestampUpdated()
        );
    }
}
