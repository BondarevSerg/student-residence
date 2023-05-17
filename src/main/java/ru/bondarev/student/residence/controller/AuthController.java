package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.rabbitMQ.RabbitMQProducerUser;
import ru.bondarev.student.residence.service.Imp.UserServiceImp;


/**
 * контроллер регистрации нового пользователя
 */
@RestController
@RequestMapping("/new_user")
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImp userService;
     private final RabbitMQProducerUser rabbitMQProducerUser;

    /**
     * Сохранение нового пользователя
     * @param userRequest
     * @return
     */
    @PostMapping()

    public ResponseEntity<HttpStatus> addNewUser(@RequestBody UserRequest userRequest) {
        rabbitMQProducerUser.sendMessage(userRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }




}
