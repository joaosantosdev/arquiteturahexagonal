package br.com.ourmind.personmicroservice.application.configurations;

import br.com.ourmind.personmicroservice.domain.ports.in.PersonServicePort;
import br.com.ourmind.personmicroservice.domain.ports.out.AddressRepositoryPort;
import br.com.ourmind.personmicroservice.domain.ports.out.CEPIntegrationPort;
import br.com.ourmind.personmicroservice.domain.ports.out.PersonRepositoryPort;
import br.com.ourmind.personmicroservice.domain.ports.out.QueueServicePort;
import br.com.ourmind.personmicroservice.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private CEPIntegrationPort cpfIntegrationPort;

    @Autowired
    private PersonRepositoryPort personRepositoryPort;

    @Autowired
    private QueueServicePort queueServicePort;

    @Autowired
    private AddressRepositoryPort addressRepositoryPort;

    @Bean
    public PersonServicePort personServicePort(){
        return new PersonService(this.personRepositoryPort,
                this.addressRepositoryPort,
                this.cpfIntegrationPort,
                this.queueServicePort);
    }
}
