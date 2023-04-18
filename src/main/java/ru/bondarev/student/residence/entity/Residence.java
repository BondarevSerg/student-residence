package ru.bondarev.student.residence.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.bondarev.student.residence.common.Gender;

import java.util.List;

/**
 * Общежитие
 */
@Entity
@Table(name = "residence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Residence {
    /**
     * id общежития
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * вместимость
     */
    @Column(name = "capacity")
    private Long capacity;

    /**
     * тип общежития
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    /**
     * университет
     */
    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private University university;

    /**
     * Список студентов
     */
    @OneToMany(mappedBy = "residence")
    private List<Student> students;
}
