package br.com.ourmind.personmicroservice.adapters.in.web.dtos;

public class PersonUpdateDTO {

    private String name;
    private AddressDTO address;

    public PersonUpdateDTO(String name, AddressDTO address) {
        this.name = name;
        this.address = address;
    }

    public PersonUpdateDTO() {
    }

    public String getName() {
        return name;
    }

    public AddressDTO getAddress() {
        return address;
    }


}
