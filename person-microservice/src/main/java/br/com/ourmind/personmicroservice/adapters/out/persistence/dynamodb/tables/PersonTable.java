package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "persons")
public class PersonTable {

    @DynamoDBHashKey(attributeName = "cpf")
    private String cpf;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "timestampCreated")
    private Long timestampCreated;

    @DynamoDBAttribute(attributeName = "timestampUpdated")
    private Long timestampUpdated;

    public PersonTable(String cpf, String name, Long timestampCreated, Long timestampUpdated) {
        this.cpf = cpf;
        this.name = name;
        this.timestampCreated = timestampCreated;
        this.timestampUpdated = timestampUpdated;
    }

    public PersonTable() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(Long timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public Long getTimestampUpdated() {
        return timestampUpdated;
    }

    public void setTimestampUpdated(Long timestampUpdated) {
        this.timestampUpdated = timestampUpdated;
    }
}
