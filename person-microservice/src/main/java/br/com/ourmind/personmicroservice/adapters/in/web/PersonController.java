package br.com.ourmind.personmicroservice.adapters.in.web;

import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonDTO;
import br.com.ourmind.personmicroservice.adapters.in.web.dtos.PersonUpdateDTO;
import br.com.ourmind.personmicroservice.adapters.in.web.mappers.PersonMapper;
import br.com.ourmind.personmicroservice.domain.ports.in.PersonServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonServicePort personServicePort;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PersonDTO personDTO){
        this.personServicePort.save(PersonMapper.map(personDTO));
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{cpf}")
    public ResponseEntity<Void> update(@PathVariable String cpf, @RequestBody PersonUpdateDTO personDTO){
        this.personServicePort.update(cpf, PersonMapper.map(cpf, personDTO));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PersonDTO> create(@PathVariable String cpf){
        PersonDTO dto = this.personServicePort.get(cpf);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
        this.personServicePort.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
