package ru.bondarev.student.residence.dto.request;

import lombok.Data;

/**
 * запрос общежития
 */
@Data
public class ResidenceRequest {

    private Long capacity;

    private String gender;

    private Long universityId;
}
