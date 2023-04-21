package ru.bondarev.student.residence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.student.residence.dto.response.UserResponse;
import ru.bondarev.student.residence.entity.User;

import java.util.Optional;

@Mapper
public interface UserMapper {

UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

 @Mapping(source = "id", target = "id")
    UserResponse toDto(User user);
}
