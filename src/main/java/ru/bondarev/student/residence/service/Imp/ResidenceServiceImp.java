package ru.bondarev.student.residence.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.common.Gender;
import ru.bondarev.student.residence.dto.request.ResidenceRequest;
import ru.bondarev.student.residence.dto.response.ResidenceResponse;
import ru.bondarev.student.residence.entity.University;
import ru.bondarev.student.residence.mappers.ResidenceMapper;
import ru.bondarev.student.residence.repositories.ResidenceRepository;
import ru.bondarev.student.residence.service.ResidenceService;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с общежитиями
 */

@Service
@RequiredArgsConstructor
public class ResidenceServiceImp implements ResidenceService {

    private  final ResidenceRepository residenceRepository;

    /**
     * получение общежития по id
     * @param id
     * @return
     */
    @Override
    public ResidenceResponse getResidence(Long id) {

        return ResidenceMapper.MAPPER.toDto(residenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено общежитие по идентификатору")));
    }

    /**
     * все общежития
     * @return
     */
    @Override
    public List<ResidenceResponse> getAllResidence() {

        return residenceRepository.findAll().stream()
                .map(ResidenceMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveResidence(ResidenceRequest residenceRequest) {

        residenceRepository.save(ResidenceMapper.MAPPER.toEntity(residenceRequest));
    }

    /**
     * Удаление общежития по id, если в нем нет студентов
     * @param id
     */
    @Override
    public void deleteResidence(Long id) {
          var residence= residenceRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Не найдено общежитие по идентификатору: " + id));
          if (residence.getStudents().isEmpty()){
              residenceRepository.delete(residence);
          }
    }

    @Override
    public void updateResidence(Long id, ResidenceRequest residenceRequest) {
        var residence= residenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено общежитие по идентификатору: " + id));
        residence.setCapacity(residenceRequest.getCapacity());
        residence.setGender(Gender.valueOf(residenceRequest.getGender()));
        residence.setUniversity(University.builder().
                id(residenceRequest.getUniversityId())
                .build());
        residenceRepository.save(residence);
    }
}
