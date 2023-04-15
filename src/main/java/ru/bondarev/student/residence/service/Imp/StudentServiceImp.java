package ru.bondarev.student.residence.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.common.Gender;
import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.response.StudentResponse;
import ru.bondarev.student.residence.entity.Residence;
import ru.bondarev.student.residence.entity.Student;
import ru.bondarev.student.residence.mappers.StudentMapper;
import ru.bondarev.student.residence.repositories.ResidenceRepository;
import ru.bondarev.student.residence.repositories.StudentRepository;
import ru.bondarev.student.residence.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    private final ResidenceRepository residenceRepository;
    @Override
    public StudentResponse getStudentById(Long id) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден студент по идентификатору: " + id));
        return StudentMapper.INSTANCE.toDTO(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(StudentMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveStudent(StudentRequest studentRequest) {

        var residence = residenceRepository.findByGender(Gender.valueOf(studentRequest.getGender()));

        if(studentRequest.getGender().equals("MALE")&
                (residence.getStudents().size() < residence.getCapacity())) {

            studentRepository.save( Student.builder()
                                    .name(studentRequest.getName())
                                    .gender(Gender.MALE)
                                    .residence(residence)
                                    .build());
        }else if (residence.getStudents().size() < residence.getCapacity()){
            studentRepository.save( Student.builder()
                    .name(studentRequest.getName())
                    .gender(Gender.FEMALE)
                    .residence(residence)
                    .build());

        }
    }

    @Override
    public void deleteStudent(Long id) {
         studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Long id, StudentRequest studentRequest) {
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден студент по идентификатору: " + id));
        student.setName(studentRequest.getName());
        studentRepository.save(student);
    }


}
