package br.com.ourmind.personmicroservice.adapters.out.integrations.cep;

import br.com.ourmind.personmicroservice.application.exceptions.IntegrationException;
import br.com.ourmind.personmicroservice.domain.ports.out.CEPIntegrationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CEPIntegrationService implements CEPIntegrationPort {

    @Autowired
    private CEPClientFeign cepClientFeign;
    @Override
    public void validate(String cep) {
        ResponseEntity<Object> response = this.cepClientFeign.get(cep);
        Map body = (Map) response.getBody();
        if(!response.getStatusCode().is2xxSuccessful() || body.containsKey("erro")){
            throw IntegrationException.of("CEP",
                    "Erro ao obter cep",
                    response.getStatusCode().value());
        }
    }
}
