package ru.bondarev.student.residence.dto.request;

import lombok.Data;

/**
 * запрос студента
 */
@Data
public class StudentRequest {

    /**
     * имя
     */
    private String name;
    /**
     * пол студента
     */
    private String gender;


}
