package br.com.ourmind.personmicroservice.domain.services;

import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonDTO;
import br.com.ourmind.personmicroservice.adapters.in.web.mappers.PersonMapper;
import br.com.ourmind.personmicroservice.application.exceptions.BusinessException;
import br.com.ourmind.personmicroservice.commons.EventPersonConstants;
import br.com.ourmind.personmicroservice.domain.models.Address;
import br.com.ourmind.personmicroservice.domain.models.Person;
import br.com.ourmind.personmicroservice.domain.ports.in.PersonServicePort;
import br.com.ourmind.personmicroservice.domain.ports.out.AddressRepositoryPort;
import br.com.ourmind.personmicroservice.domain.ports.out.CEPIntegrationPort;
import br.com.ourmind.personmicroservice.domain.ports.out.PersonRepositoryPort;
import br.com.ourmind.personmicroservice.domain.ports.out.QueueServicePort;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class PersonService implements PersonServicePort {

    private PersonRepositoryPort personRepositoryPort;
    private AddressRepositoryPort addressRepositoryPort;
    private CEPIntegrationPort cepIntegrationPort;
    private QueueServicePort queueServicePort;

    public PersonService(PersonRepositoryPort personRepositoryPort,AddressRepositoryPort addressRepositoryPort, CEPIntegrationPort cepIntegrationPort, QueueServicePort queueServicePort) {
        this.personRepositoryPort = personRepositoryPort;
        this.addressRepositoryPort = addressRepositoryPort;
        this.cepIntegrationPort = cepIntegrationPort;
        this.queueServicePort = queueServicePort;
    }

    @Override
    public void save(Person person) {

        if(Objects.nonNull(personRepositoryPort.get(person.getCpf()))){
            throw BusinessException.of("Pessoa já cadastrada", HttpStatus.BAD_REQUEST);
        }

        cepIntegrationPort.validate(person.getAddress().getCep());

        personRepositoryPort.save(person);
        addressRepositoryPort.save(person.getAddress());

        this.queueServicePort.sendMessage(EventPersonConstants.SAVED, person);
    }

    @Override
    public void update(String cpf, Person person) {
        Person personSaved = personRepositoryPort.get(person.getCpf());

        if(personSaved != null && !personSaved.getCpf().equals(person.getCpf())){
            throw BusinessException.of("Novo CPF já está cadastrado", HttpStatus.BAD_REQUEST);
        }

        cepIntegrationPort.validate(person.getAddress().getCep());

        personRepositoryPort.save(person);
        addressRepositoryPort.save(person.getAddress());

        this.queueServicePort.sendMessage(EventPersonConstants.UPDATED, person);
    }

    @Override
    public PersonDTO get(String cpf) {
        Person person = personRepositoryPort.get(cpf);

        if(person == null){
            throw BusinessException.of("Pessoa não encontrada", HttpStatus.NOT_FOUND);
        }

        Address address = addressRepositoryPort.get(cpf);


        this.queueServicePort.sendMessage(EventPersonConstants.READ, person);
        return PersonMapper.map(person, address);
    }

    @Override
    public void delete(String cpf) {
        Person person = personRepositoryPort.get(cpf);

        if(person == null){
            throw BusinessException.of("Pessoa não encontrada", HttpStatus.NOT_FOUND);
        }

        personRepositoryPort.delete(person);
        Address address = addressRepositoryPort.get(cpf);

        if(address != null){
            addressRepositoryPort.delete(address);
        }

        this.queueServicePort.sendMessage(EventPersonConstants.DELETED, person);
    }

}
