package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.ResidenceRequest;
import ru.bondarev.student.residence.dto.response.ResidenceResponce;
import ru.bondarev.student.residence.service.Imp.ResidenceServiceImp;

import java.util.List;

/**
 * контроллер работы с общежитием
 */
@RestController
@RequestMapping("/residencies")
@RequiredArgsConstructor
public class ResidenceController {
    private final ResidenceServiceImp residenceServiceImp;


    /**
     * Получение  общежития по id
     * @return
     */
    @GetMapping("{id}")

    public ResidenceResponce getResidence(@PathVariable ("id")Long id) {
        return residenceServiceImp.getResidence(id);
    }
    /**
     * Получение списка общежитий
     * @return
     */
    @GetMapping()

    public List<ResidenceResponce> getAllResidence() {
        return residenceServiceImp.getAllResidence();
    }

    /**
     * сохранение нового общежития
     * @param residenceRequest
     * @return
     */
    @PostMapping()

    public ResponseEntity<HttpStatus> create(@RequestBody ResidenceRequest residenceRequest) {


        residenceServiceImp.saveResidence(residenceRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление общежития по id
     * @param id
     * @return
     */
    @DeleteMapping ("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        residenceServiceImp.deleteResidence(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * Обновление общежития
     * @param id
     * @param residenceRequest
     * @return
     */
    @PutMapping  ("{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id,
                                             @RequestBody ResidenceRequest residenceRequest) {

        residenceServiceImp.updateResidence(id, residenceRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
