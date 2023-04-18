package ru.bondarev.student.residence.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import ru.bondarev.student.residence.entity.Residence;

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

    private List<ResidenceResponce> residences;
}
