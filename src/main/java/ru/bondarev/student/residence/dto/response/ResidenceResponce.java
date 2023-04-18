package ru.bondarev.student.residence.dto.response;

import lombok.Data;


import java.util.List;

/**
 * dto ответа общежитие
 */
@Data
public class ResidenceResponce {
    /**
     * id
     */
    private Long id;
    /**
     * количество мест
     */
    private Long capacity;
    /**
     * тип общежития
     */
    private String gender;
    /**
     * id университета
     */
    private Long universityId;
    /**
     * список имен  проживающих студентов
     */
    private List<String> studentsName;
}
