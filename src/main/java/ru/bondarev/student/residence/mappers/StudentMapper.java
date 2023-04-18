package ru.bondarev.student.residence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.student.residence.dto.request.StudentRequest;
import ru.bondarev.student.residence.dto.response.StudentResponse;
import ru.bondarev.student.residence.entity.Student;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );
    @Mapping(source = "id", target = "id")
    @Mapping(source = "gender.type", target = "gender")
    StudentResponse toDTO(Student student);

   @Mapping(source = "name", target = "name")
   @Mapping(source = "gender", target = "gender")
   Student toEntity(StudentRequest studentRequest);

}
