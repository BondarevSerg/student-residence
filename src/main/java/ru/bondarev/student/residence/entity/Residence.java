package ru.bondarev.student.residence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

//    /**
//     * название общежития
//     */
//    @Column(name = "name")
//    private String name;

    /**
     * вместимость(не более 100)
     */
    @Column(name = "capacity")
    @Size(max = 5)
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
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private University university;

    /**
     * Список студентов
     */
    @OneToMany(mappedBy = "residence")
    private List<Student> students;
}
