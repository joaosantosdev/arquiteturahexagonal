package br.com.ourmind.personmicroservice.application.exceptions;

public class IntegrationException extends RuntimeException{
    private String name;
    private String message;
    private Integer status;

    private IntegrationException(String name, String message, Integer status){
        this.name = name;
        this.message = message;
        this.status = status;
    }

    public static IntegrationException of(String name, String message, Integer status){
        return new IntegrationException(name, message, status);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
