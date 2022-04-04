package br.com.ourmind.personmicroservice.adapters.out.integrations.cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${integrations.cep}", name = "CEP")
public interface CEPClientFeign {

    @GetMapping("/{cep}/json")
    ResponseEntity<Object> get(@RequestParam String cep);

}
