package ru.bondarev.student.residence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.student.residence.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
