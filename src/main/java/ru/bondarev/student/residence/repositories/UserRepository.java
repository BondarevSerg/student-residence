package ru.bondarev.student.residence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.student.residence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
