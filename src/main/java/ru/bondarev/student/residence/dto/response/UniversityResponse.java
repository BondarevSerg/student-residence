package ru.bondarev.student.residence.dto.response;

import lombok.Data;

import java.util.List;

/**
 * dto ответа университет
 */
@Data

public class UniversityResponse {

    private Long id;
    /**
     * название учебного заведения
     */

    private String name;

    /**
     * Список общежитий
     */

    private List<ResidenceResponse> residences;
}
