package br.com.ourmind.personmicroservice.domain.ports.out;

import br.com.ourmind.personmicroservice.domain.models.Address;
import br.com.ourmind.personmicroservice.domain.models.Person;

public interface AddressRepositoryPort {
    void save(Address address);
    void delete(Address address);
    void update(Address address);
    Address get(String id);
}
