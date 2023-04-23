package ru.bondarev.student.residence.service.Imp;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.dto.response.UserResponse;
import ru.bondarev.student.residence.entity.User;
import ru.bondarev.student.residence.mappers.UserMapper;
import ru.bondarev.student.residence.repositories.UserRepository;
import ru.bondarev.student.residence.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private  final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * Получение пользователя по id
     * @param id
     * @return
     */
    @Override
    public UserResponse getUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
        return UserMapper.MAPPER.toDto(user);
    }

    /**
     * Список всех  пользователей
     * @return
     */
    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll().stream()
                .map(UserMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Сохранение нового пользователя(с ролью USER)
     * @return
     */
    @Override
    public void saveUser(UserRequest userRequest) {
        var user = User.builder()
                .login(userRequest.getLogin())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
    }

    /**
     * удаление пользователя по id(кроме ADMIN)
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
        if(user.getRole().equals("ROLE_USER")) {
            userRepository.delete(user);
        }

    }
    /**
     * обновление пользователя по id
     * @param id
     */
    @Override
    public void updateUser(Long id, UserRequest userRequest) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
        user.setLogin(userRequest.getLogin());
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

}
