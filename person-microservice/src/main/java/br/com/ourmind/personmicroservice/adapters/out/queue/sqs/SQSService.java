package br.com.ourmind.personmicroservice.adapters.out.queue.sqs;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class SQSService   {

    private SqsClient sqsClient;

    private Gson gson = new GsonBuilder().create();

    public <T> void send(String queueName, T data){
        String message = gson.toJson(data);
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(getUrlQueue(queueName))
                .messageBody(message)
                .build();

        this.client().sendMessage(sendMessageRequest);
    }


    private String getUrlQueue(String queueName){
      GetQueueUrlRequest queueUrlRequest = GetQueueUrlRequest.builder()
              .queueName(queueName)
              .build();
      return  this.client().getQueueUrl(queueUrlRequest).queueUrl();
    }

    public abstract SQSConfiguration configuration();

    final protected SqsClient client(){
        if(sqsClient == null){
            SQSConfiguration sqsConfiguration = this.configuration();
            try {
                sqsClient = SqsClient.builder().region(Region.of(sqsConfiguration.getRegion()))
                        .credentialsProvider(DefaultCredentialsProvider.create())
                        .endpointOverride(new URI(sqsConfiguration.getEndpoint()))
                        .build();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return sqsClient;
    }

}
