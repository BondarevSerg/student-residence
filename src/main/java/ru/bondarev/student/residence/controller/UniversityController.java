package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.UniversityRequest;
import ru.bondarev.student.residence.dto.response.UniversityResponse;
import ru.bondarev.student.residence.service.Imp.UniversityServiceImp;

import java.util.List;

/**
 * контроллер работы с университетом
 */
@RestController
@RequestMapping("/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityServiceImp universityServiceImp;

    /**
     * Получение списка университетов
     * @return
     */
    @GetMapping()

    public List<UniversityResponse> getAllUniversity() {
        return universityServiceImp.getAllUniversity();
    }

    /**
     * Получение  университета по id
     * @param id
     * @return
     */
    @GetMapping("{id}")

    public UniversityResponse getUniversityById(@PathVariable("id")Long id) {
        return universityServiceImp.getUniversityById(id);
    }

    /**
     * сохранение нового университета
     * @param universityRequest
     * @return
     */
    @PostMapping()

    public ResponseEntity<HttpStatus> create(@RequestBody UniversityRequest universityRequest) {


        universityServiceImp.saveUniversity(universityRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление университета по id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")

    public ResponseEntity<HttpStatus> create(@PathVariable("id")Long id) {


        universityServiceImp.deleteUniversity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * обновление  университета по id
     * @param id
     * @param universityRequest
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id, @RequestBody UniversityRequest universityRequest) {

        universityServiceImp.updateUniversity(id, universityRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
