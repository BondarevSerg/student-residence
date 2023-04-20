package ru.bondarev.student.residence.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String login;
    private String password;
}
