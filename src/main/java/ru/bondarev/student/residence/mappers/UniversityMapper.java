package ru.bondarev.student.residence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.student.residence.dto.request.UniversityRequest;
import ru.bondarev.student.residence.dto.response.UniversityResponse;
import ru.bondarev.student.residence.entity.University;


@Mapper(uses = { ResidenceMapper.class })

public interface UniversityMapper {
     UniversityMapper MAPPER = Mappers.getMapper(UniversityMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "residences", target = "residences")
     UniversityResponse toDto(University university);


    @Mapping(source = "name", target = "name")
//    @Mapping(source = "residences", target = "residences")
    University toEntity(UniversityRequest universityRequest);

}
