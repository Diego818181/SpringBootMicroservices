package tec.utpl.store.servicecurso.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Table(name="tbl_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number_id", unique = true, nullable = false)
    private String numberId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name="period")
    private String period;

    @Column(name="state")
    private String state;

}
