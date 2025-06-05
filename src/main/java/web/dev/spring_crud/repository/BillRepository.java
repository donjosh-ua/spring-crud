package web.dev.spring_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.dev.spring_crud.domain.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findAllByPersonId(Long personId);

    @Modifying
    @Query("DELETE FROM Bill b WHERE b.person.id = ?1")
    void deleteAllByPersonId(Long personId);

}
