package br.com.ourmind.personmicroservice.application.handlers;

import br.com.ourmind.personmicroservice.application.exceptions.BusinessException;
import br.com.ourmind.personmicroservice.application.exceptions.IntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler(IntegrationException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public ErroResponse integrationException(IntegrationException e){
        return ErroResponse.of(e);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<ErroResponse> businessException(BusinessException e){
        return ResponseEntity.status(e.getStatus().value()).body(ErroResponse.of(e));
    }
}
