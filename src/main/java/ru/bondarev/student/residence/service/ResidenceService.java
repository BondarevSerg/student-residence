package ru.bondarev.student.residence.service;

import ru.bondarev.student.residence.dto.request.ResidenceRequest;
import ru.bondarev.student.residence.dto.response.ResidenceResponce;


import java.util.List;

public interface ResidenceService {
    /**
     * Получение общежития по id
     *
     * @return
     */
    ResidenceResponce getResidence(Long id);

    /**
     * Получение списка всех общежитий
     *
     * @return
     */
    List<ResidenceResponce> getAllResidence();

    /**
     * сохранение нового общежития
     *
     * @param residenceRequest
     */
    void saveResidence(ResidenceRequest residenceRequest);

    /**
     * удаление общежития по id
     *
     * @param id
     */
    void deleteResidence(Long id);

    /**
     * обновление общежития по id
     */
    void updateResidence(Long id, ResidenceRequest residenceRequest);



}
