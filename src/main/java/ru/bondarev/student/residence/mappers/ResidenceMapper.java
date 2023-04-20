package ru.bondarev.student.residence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.student.residence.dto.request.ResidenceRequest;
import ru.bondarev.student.residence.dto.response.ResidenceResponse;
import ru.bondarev.student.residence.entity.Residence;
import ru.bondarev.student.residence.entity.Student;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = { StudentMapper.class })
public interface ResidenceMapper {
    ResidenceMapper MAPPER = Mappers.getMapper(ResidenceMapper.class );
    @Mapping(source = "id", target = "id")
    @Mapping(source = "university.id", target = "universityId")
    @Mapping(source = "students", target = "studentsName")
    ResidenceResponse toDto(Residence residence);
    default List<String> map(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }
    @Mapping(source = "capacity", target = "capacity")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "universityId", target = "university.id")
    Residence toEntity(ResidenceRequest  residenceRequest);

}
