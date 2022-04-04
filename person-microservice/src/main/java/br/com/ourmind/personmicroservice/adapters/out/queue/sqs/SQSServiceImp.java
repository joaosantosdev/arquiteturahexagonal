package br.com.ourmind.personmicroservice.adapters.out.queue.sqs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SQSServiceImp extends SQSService{

    @Value("${sqs.region}")
    private String region;

    @Value("${sqs.endpoint}")
    private String endpoint;

    @Override
    public SQSConfiguration configuration() {
        return new SQSConfiguration(endpoint, region);
    }
}
