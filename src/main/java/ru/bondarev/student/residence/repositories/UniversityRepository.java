package ru.bondarev.student.residence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.student.residence.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
