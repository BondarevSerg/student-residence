package ru.bondarev.student.residence.service;


import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.dto.response.StudentResponse;
import ru.bondarev.student.residence.dto.response.UserResponse;

import java.util.List;


public interface UserService {

    /**
     * Получение пользователя по id
     *
     * @return
     */
    UserResponse getUserById(Long id);

    /**
     * Получение списка всех пользователей
     *
     * @return
     */
    List<UserResponse> getAllUsers();
    /**
     * сохранение нового пользователя
     *
     * @param userRequest
     */
    void saveUser(UserRequest userRequest);
    /**
     * удаление пользователя по id
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * обновление данных польтзоваьтеля по его id
     */
    void updateUser(Long id, UserRequest userRequest);


}
