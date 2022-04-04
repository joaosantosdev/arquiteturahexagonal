package br.com.ourmind.personmicroservice.adapters.in.web.dtos;

public class AddressDTO {

    private String cep;
    private String number;
    private String description;

    public AddressDTO(String cep, String number, String description) {
        this.cep = cep;
        this.number = number;
        this.description = description;
    }

    public AddressDTO() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
