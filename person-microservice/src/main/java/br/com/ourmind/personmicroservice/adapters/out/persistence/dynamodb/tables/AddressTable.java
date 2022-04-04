package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "addresses")
public class AddressTable {

    @DynamoDBHashKey(attributeName = "cpf")
    private String cpf;

    @DynamoDBAttribute(attributeName = "cep")
    private String cep;

    @DynamoDBAttribute(attributeName = "number")
    private String number;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    public AddressTable() {
    }

    public AddressTable(String cpf, String cep, String number, String description) {
        this.cpf = cpf;
        this.cep = cep;
        this.number = number;
        this.description = description;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
