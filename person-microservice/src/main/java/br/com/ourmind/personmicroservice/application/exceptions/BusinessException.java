package br.com.ourmind.personmicroservice.application.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
    private HttpStatus status;

    private BusinessException(String message, Throwable cause){
        super(message, cause);
    }

    private BusinessException(String message, HttpStatus status){
        super(message, null);
        this.status = status;
    }

    public static BusinessException of(String message, Throwable cause){
        return new BusinessException(message, cause);
    }

    public static BusinessException of(String message, HttpStatus status){
        return new BusinessException(message, status);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
