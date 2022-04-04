package br.com.ourmind.personmicroservice.domain.models;

public class Person {

    private String cpf;
    private String name;
    private Long timestampCreated;
    private Long timestampUpdated;

    private Address address;

    public Person(String cpf, String name, Address address) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
    }

    public Person(String cpf, String name, Long timestampCreated, Long timestampUpdated) {
        this.cpf = cpf;
        this.name = name;
        this.timestampCreated = timestampCreated;
        this.timestampUpdated = timestampUpdated;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }


    public Long getTimestampCreated() {
        return timestampCreated;
    }


    public Long getTimestampUpdated() {
        return timestampUpdated;
    }


    public Address getAddress() {
        return address;
    }

}
