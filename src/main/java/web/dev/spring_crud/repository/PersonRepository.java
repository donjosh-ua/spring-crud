package web.dev.spring_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.dev.spring_crud.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
