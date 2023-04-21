package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.ResidenceRequest;
import ru.bondarev.student.residence.dto.response.ResidenceResponse;
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResidenceResponse getResidence(@PathVariable ("id")Long id) {
        return residenceServiceImp.getResidence(id);
    }
    /**
     * Получение списка общежитий
     * @return
     */
    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<ResidenceResponse> getAllResidence() {
        return residenceServiceImp.getAllResidence();
    }

    /**
     * сохранение нового общежития
     * @param residenceRequest
     * @return
     */
    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id,
                                             @RequestBody ResidenceRequest residenceRequest) {

        residenceServiceImp.updateResidence(id, residenceRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
