package ru.bondarev.student.residence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/**
 * университет
 */
@Entity
@Table(name = "university")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class University {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * название учебного заведения
     */
    @Column(name = "name")
    private String name;

    /**
     * Список общежитий
     */
    @OneToMany(mappedBy = "university")
    private List<Residence> residences;
}
