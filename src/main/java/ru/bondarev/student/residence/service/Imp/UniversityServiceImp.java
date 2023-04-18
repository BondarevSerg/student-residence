package ru.bondarev.student.residence.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.UniversityRequest;
import ru.bondarev.student.residence.dto.response.UniversityResponse;
import ru.bondarev.student.residence.mappers.UniversityMapper;
import ru.bondarev.student.residence.repositories.UniversityRepository;
import ru.bondarev.student.residence.service.UniversityService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с университетом
 */

@Service
@RequiredArgsConstructor
public class UniversityServiceImp implements UniversityService {


    private final UniversityRepository universityRepository;

    @Override
    public UniversityResponse getUniversityById(Long id) {
        var university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден университет по идентификатору: " + id));
        return UniversityMapper.MAPPER.toDto(university);
    }

    @Override
    public List<UniversityResponse> getAllUniversity() {
        return universityRepository.findAll().stream()
                .map(UniversityMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUniversity(UniversityRequest universityRequest) {

             universityRepository.save(UniversityMapper.MAPPER.toEntity(universityRequest));


    }

    @Override
    public void deleteUniversity(Long id) {
         universityRepository.deleteById(id);
    }

    @Override
    public void updateUniversity(Long id, UniversityRequest universityRequest) {
        var university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден университет по идентификатору: " + id));
        university.setName(universityRequest.getName());
         universityRepository.save(university);
    }
}
