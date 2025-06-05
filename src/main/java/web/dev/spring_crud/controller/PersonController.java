package web.dev.spring_crud.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import web.dev.spring_crud.domain.dto.PersonDTO;
import web.dev.spring_crud.service.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPersons() {
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok().body(personService.updatePerson(fields));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.ok().body(personService.createPerson(person));
    }

    @DeleteMapping("/deleteById/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer personId) {
        return ResponseEntity.ok().body(personService.deletePerson(personId));
    }

}
