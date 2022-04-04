package br.com.ourmind.personmicroservice.adapters.out.persistence;

import br.com.ourmind.personmicroservice.adapters.in.web.mappers.AddressMapper;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.DynamoDBService;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.mappers.AddressTableMapper;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.AddressTable;
import br.com.ourmind.personmicroservice.domain.models.Address;
import br.com.ourmind.personmicroservice.domain.ports.out.AddressRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressDynamoRepository  implements AddressRepositoryPort {
    @Autowired
    private DynamoDBService<AddressTable> dynamoDBService;

    @Override
    public void save(Address address) {
        dynamoDBService.save(AddressTableMapper.map(address));
    }

    @Override
    public void delete(Address address) {
        dynamoDBService.delete(AddressTableMapper.map(address));
    }

    @Override
    public void update(Address address) {
        dynamoDBService.update(AddressTableMapper.map(address));
    }

    @Override
    public Address get(String id) {
        return AddressMapper.map(dynamoDBService.get(AddressTable.class, id));
    }
}
