package br.com.ourmind.personmicroservice.adapters.in.web.dtos;

public class PersonDTO {

    private String cpf;
    private String name;
    private AddressDTO address;

    public PersonDTO(String cpf, String name, AddressDTO address) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
    }

    public PersonDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public AddressDTO getAddress() {
        return address;
    }


}
