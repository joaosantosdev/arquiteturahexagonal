package br.com.ourmind.personmicroservice.application.handlers;

import br.com.ourmind.personmicroservice.application.exceptions.BusinessException;
import br.com.ourmind.personmicroservice.application.exceptions.IntegrationException;

public class ErroResponse {
    private String name;
    private String message;
    private Integer status;

    public ErroResponse(String name, String message, Integer status) {
        this.name = name;
        this.message = message;
        this.status = status;
    }

    public static ErroResponse of(IntegrationException e){
        return new ErroResponse(e.getName(), e.getMessage(), e.getStatus());
    }

    public static ErroResponse of(BusinessException e) {
        return new ErroResponse("BUSINESS_EXCEPTION", e.getMessage(), e.getStatus().value());
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
