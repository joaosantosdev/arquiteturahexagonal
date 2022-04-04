package br.com.ourmind.personmicroservice.adapters.in.web.mappers;

import br.com.ourmind.personmicroservice.adapters.in.web.dtos.AddressDTO;
import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonDTO;
import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonUpdateDTO;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.PersonTable;
import br.com.ourmind.personmicroservice.domain.models.Address;
import br.com.ourmind.personmicroservice.domain.models.Person;

import java.util.Objects;

public class PersonMapper {

    public static Person map(PersonDTO personDTO){
        return new Person(personDTO.getCpf(),
                personDTO.getName(),
                AddressMapper.map(personDTO.getCpf(), personDTO.getAddress()));
    }

    public static Person map(PersonTable personDTO){
        if(Objects.isNull(personDTO))
            return null;

        return new Person(personDTO.getCpf(),
                personDTO.getName(),
                personDTO.getTimestampCreated(),
                personDTO.getTimestampCreated());
    }

    public static PersonDTO map(Person person, Address address){
        if(person == null)
            return null;

        return new PersonDTO(person.getCpf(), person.getName() , AddressMapper.map(address));
    }

    public static Person map(String cpf, PersonUpdateDTO personDTO) {
        return new Person(cpf,
                personDTO.getName(),
                AddressMapper.map(cpf, personDTO.getAddress()));
    }
}
