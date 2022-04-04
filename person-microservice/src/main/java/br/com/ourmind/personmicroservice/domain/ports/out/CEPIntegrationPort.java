package br.com.ourmind.personmicroservice.domain.ports.out;

public interface CEPIntegrationPort {
    void validate(String cpf);
}
