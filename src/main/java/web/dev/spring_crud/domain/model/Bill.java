package web.dev.spring_crud.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Float amount;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "topic", nullable = false)
    private String topic;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
