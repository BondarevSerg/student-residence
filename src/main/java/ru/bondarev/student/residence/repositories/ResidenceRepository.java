package ru.bondarev.student.residence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bondarev.student.residence.common.Gender;
import ru.bondarev.student.residence.entity.Residence;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {

    @Query("SELECT r FROM Residence r   WHERE r.gender = :gender")
    Residence findByGender(Gender gender);
}
