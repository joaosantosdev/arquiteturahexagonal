package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.mappers;

import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.AddressTable;
import br.com.ourmind.personmicroservice.domain.models.Address;

public class AddressTableMapper {
    public static AddressTable map(Address address){
        return new AddressTable(address.getCpfPerson(),
                address.getCep(),
                address.getNumber(),
                address.getDescription());
    }
}
