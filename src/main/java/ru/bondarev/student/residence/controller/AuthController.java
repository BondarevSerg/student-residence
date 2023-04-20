package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bondarev.student.residence.dto.response.StudentResponse;

/**
 * контроллер работы с общежитием
 */
@RestController
@RequestMapping("/new_user")
@RequiredArgsConstructor
public class AuthController {
    /**
     * Получение  студента по id
     *
     * @return
     */
    @GetMapping()

    public ResponseEntity<HttpStatus> create() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
