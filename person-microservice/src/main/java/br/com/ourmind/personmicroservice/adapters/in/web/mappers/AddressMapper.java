package br.com.ourmind.personmicroservice.adapters.in.web.mappers;

import br.com.ourmind.personmicroservice.adapters.in.web.dtos.AddressDTO;
import br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables.AddressTable;
import br.com.ourmind.personmicroservice.domain.models.Address;

public class AddressMapper {

    public static Address map(String cpf, AddressDTO addressDTO){
        return new Address(cpf, addressDTO.getCep(), addressDTO.getNumber(), addressDTO.getDescription());
    }

    public static AddressDTO map(Address address){
        return new AddressDTO(address.getCep(), address.getNumber(), address.getDescription());
    }

    public static Address map(AddressTable addressTable) {
        return new Address(addressTable.getCpf(), addressTable.getCep(), addressTable.getNumber(), addressTable.getDescription());
    }
}
