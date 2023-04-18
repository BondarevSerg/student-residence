package ru.bondarev.student.residence.service;

import ru.bondarev.student.residence.dto.request.UniversityRequest;
import ru.bondarev.student.residence.dto.response.UniversityResponse;

import java.util.List;

public interface UniversityService {

    /**
     * Получение университета по id
     *
     * @return
     */
    UniversityResponse getUniversityById(Long id);

    /**
     * Получение списка университетов
     *
     * @return
     */
    List<UniversityResponse> getAllUniversity();

    /**
     * сохранение нового общежития
     *
     * @param universityRequest
     */
    void saveUniversity(UniversityRequest universityRequest);

    /**
     * удаление университета по id
     *
     * @param id
     */
    void deleteUniversity(Long id);

    /**
     * обновление общежития по id
     */
    void updateUniversity(Long id, UniversityRequest universityRequest);

}
