package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.dto.response.UserResponse;
import ru.bondarev.student.residence.service.Imp.UserServiceImp;

import java.util.List;

/**
 * контроллер работы с пользователем
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserServiceImp userService;

    /**
     * Получение списка пользователей
     *
     * @return
     */
    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Получение  пользователя по id
     *
     * @return
     */
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserResponse getUserById(@PathVariable("id")Long id) {
        return userService.getUserById(id);
    }


    /**
     * удаление пользователя по id(кроме ADMIN)
     * @param id
     * @return
     */
    @DeleteMapping ("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * обновление  пользователя по id
     * @param id
     * @param userRequest
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id, UserRequest userRequest) {

        userService.updateUser(id, userRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }


}
