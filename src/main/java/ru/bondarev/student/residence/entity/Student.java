package ru.bondarev.student.residence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.bondarev.student.residence.common.Gender;
/**
 * студент
 */
@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Student {
    /**
     * id студента
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя
     */

    @Column(name = "name")
    @Size(min=2, max=30)
    private String name;

    /**
     * пол
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    /**
     * общежитие
     */

    @ManyToOne
    @JoinColumn(name = "residence_id", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Residence residence;

}
