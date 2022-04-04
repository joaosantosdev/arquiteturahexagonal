package br.com.ourmind.personmicroservice.domain.models;

import br.com.ourmind.personmicroservice.domain.ports.out.CEPIntegrationPort;

public class Address {

    private String cpfPerson;
    private String cep;
    private String number;
    private String description;

    public Address(String cpfPerson, String cep, String number, String description) {
        this.cpfPerson = cpfPerson;
        this.cep = cep;
        this.number = number;
        this.description = description;
    }

    public Address(String cep, String number, String description) {
        this.cep = cep;
        this.number = number;
        this.description = description;
    }

    public String getCpfPerson() {
        return cpfPerson;
    }

    public String getCep() {
        return cep;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

}
