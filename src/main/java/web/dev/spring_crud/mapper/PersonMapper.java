package web.dev.spring_crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import web.dev.spring_crud.domain.dto.PersonDTO;
import web.dev.spring_crud.domain.model.Person;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PersonMapper {

    // map dto to entity
    Person toEntity(PersonDTO personDTO);

    // map entity to dto
    PersonDTO toDTO(Person person);

    // map set of dto to set of entity
    List<Person> toEntities(List<PersonDTO> personDTOs);

    // map set of entity to set of dto
    List<PersonDTO> toDTOs(List<Person> persons);

}
