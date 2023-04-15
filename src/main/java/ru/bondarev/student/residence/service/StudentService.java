package ru.bondarev.student.residence.service;

import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.response.StudentResponse;

import java.util.List;


public interface StudentService {

    /**
     * Получение студента по id
     *
     * @return
     */
    StudentResponse getStudentById(Long id);

    /**
     * Получение списка всех студентов
     *
     * @return
     */
    List<StudentResponse> getAllStudent();

    /**
     * сохранение нового студента
     *
     * @param studentRequest
     */
    void saveStudent(StudentRequest studentRequest);

    /**
     * удаление студента по id
     *
     * @param id
     */
    void deleteStudent(Long id);

    /**
     * обновление данных студента по его id
     */
    void updateStudent(Long id, StudentRequest studentRequest);


}
