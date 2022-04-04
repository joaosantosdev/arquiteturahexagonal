package br.com.ourmind.personmicroservice.adapters.out.persistence.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DynamoDBServiceImp<T> extends DynamoDBService<T> {

    @Value("${dynamodb.endpoint}")
    private String endpoint;

    @Value("${dynamodb.region}")
    private String region;

    protected AmazonDynamoDB configuration() {

        try{
            return AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(this.endpoint, this.region))
                    .build();
        }catch (Exception e){
            throw e;
        }

    }
}
