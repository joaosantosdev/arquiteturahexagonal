package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public abstract class DynamoDBService<T>{

    public T get(Class<T> tClass, Object key) {
        try{

            return this.client().load(tClass, key);
        }catch (Exception e){
            throw e;
        }
    }

    public void update(T object) {
        try{
            this.client().save(object);
        }catch (Exception e){
            throw e;
        }
    }

    public void save(T object) {
        try{
            this.client().save(object);
        }catch (Exception e){
            throw e;
        }
    }

    public void delete(T object) {
        try{
            this.client().delete(object);
        }catch (Exception e){
            throw e;
        }
    }

    private DynamoDBMapper client;

    abstract AmazonDynamoDB configuration();

    protected DynamoDBMapper client(){
        if(this.client == null){
            this.client = new DynamoDBMapper(this.configuration());
        }
        return this.client;
    }
}
