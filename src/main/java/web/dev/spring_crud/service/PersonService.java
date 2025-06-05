package web.dev.spring_crud.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import web.dev.spring_crud.domain.dto.PersonDTO;
import web.dev.spring_crud.domain.model.Person;
import web.dev.spring_crud.mapper.PersonMapper;
import web.dev.spring_crud.repository.BillRepository;
import web.dev.spring_crud.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;
    private final BillRepository billRepository;

    public List<PersonDTO> getAllPersons() {
        return personMapper.toDTOs(personRepository.findAll());
    }

    public PersonDTO createPerson(PersonDTO person) {

        if (personRepository.findById(person.id.longValue()).isPresent()) {
            throw new RuntimeException("Person already exists with id: " + person.id);
        }

        return personMapper.toDTO(personRepository.save(personMapper.toEntity(person)));
    }

    public PersonDTO updatePerson(Map<String, Object> fields) {

        Integer personId = (Integer) fields.get("id");
        Person person = personRepository.findById(personId.longValue())
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personId));

        fields.forEach((key, value) -> {
            switch (key) {
                case "name":
                    person.setName((String) value);
                    break;
                case "email":
                    person.setEmail((String) value);
                    break;
            }
        });

        return personMapper.toDTO(personRepository.save(person));
    }

    @Transactional
    public PersonDTO deletePerson(Integer personId) {

        Person person = personRepository.findById(personId.longValue())
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personId));

        PersonDTO personDTO = personMapper.toDTO(person);

        billRepository.deleteAllByPersonId(personId.longValue());
        personRepository.deleteById(personId.longValue());

        return personDTO;
    }

}
