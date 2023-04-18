package ru.bondarev.student.residence.dto.response;

import lombok.Data;
/**
 * dto ответа студент
 */
@Data
public class StudentResponse {

    /**
     * id
     */
    private Long id;
    /**
     * Имя
     */
    private String name;
    /**
     * пол
     */
    private String gender;


}
