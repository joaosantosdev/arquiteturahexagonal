package br.com.ourmind.personmicroservice.adapters.out.persistence;

import br.com.ourmind.personmicroservice.adapters.in.web.mappers.PersonMapper;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.DynamoDBService;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.mappers.PersonTableMapper;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.PersonTable;
import br.com.ourmind.personmicroservice.domain.models.Person;
import br.com.ourmind.personmicroservice.domain.ports.out.PersonRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDynamoRepository implements PersonRepositoryPort {

    @Autowired
    private DynamoDBService<PersonTable> dynamoDBService;

    @Override
    public void save(Person person) {
        dynamoDBService.save(PersonTableMapper.map(person));
    }

    @Override
    public void delete(Person person) {
        this.dynamoDBService.delete(PersonTableMapper.map(person));
    }

    @Override
    public void update(Person person) {
        dynamoDBService.save(PersonTableMapper.map(person));
    }

    @Override
    public Person get(String id) {
        PersonTable personTable = this.dynamoDBService.get(PersonTable.class, id);
        return PersonMapper.map(personTable);
    }

}
