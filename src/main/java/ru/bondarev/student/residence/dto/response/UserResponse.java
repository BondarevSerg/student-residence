package ru.bondarev.student.residence.dto.response;

import lombok.Data;
/**
 * dto ответа пользователь
 */
@Data
public class UserResponse {

    private Long id;
    private String login;
    private String role;
}
