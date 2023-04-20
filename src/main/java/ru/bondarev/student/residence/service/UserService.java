package ru.bondarev.student.residence.service;

import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.entity.User;

public interface UserService {
    /**
     * сохранение нового пользователя
     *
     * @param userRequest
     */
    void saveUser(UserRequest userRequest);
}
