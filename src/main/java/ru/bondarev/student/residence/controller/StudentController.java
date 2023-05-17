package ru.bondarev.student.residence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.response.StudentResponse;
import ru.bondarev.student.residence.service.Imp.StudentServiceImp;

import java.util.List;
/**
 * контроллер работы со студентами
 */
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private  final StudentServiceImp studentService;



    /**
     * Получение списка студентов
     *
     * @return
     */
    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }

    /**
     * Получение  студента по id
     *
     * @return
     */
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public StudentResponse getStudentById(@PathVariable("id")Long id) {
        return studentService.getStudentById(id);
    }

    /**
     * сохранение нового студента(пользователь после регистрации может сохранить студента)
     * @param studentRequest
     * @return
     */
    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> create(@RequestBody StudentRequest studentRequest) {

        studentService.saveStudent(studentRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление студента по id
     * @param id
     * @return
     */
    @DeleteMapping ("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        studentService.deleteStudent(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * обновление  студента по id
     * @param id
     * @param studentRequest
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id, StudentRequest studentRequest) {

        studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
