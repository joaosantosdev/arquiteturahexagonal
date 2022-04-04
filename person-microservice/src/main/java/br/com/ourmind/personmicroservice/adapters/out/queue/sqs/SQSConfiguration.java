package br.com.ourmind.personmicroservice.adapters.out.queue.sqs;


public class SQSConfiguration {
    private String endpoint;
    private String region;

    public SQSConfiguration(String endpoint, String region) {
        this.endpoint = endpoint;
        this.region = region;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getRegion() {
        return region;
    }

}
