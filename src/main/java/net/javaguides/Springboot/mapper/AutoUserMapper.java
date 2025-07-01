package net.javaguides.Springboot.mapper;

import net.javaguides.Springboot.dto.UserDto;
import net.javaguides.Springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    // we are creating autouser mapper to map the objects here the AutoUserMapper is a interface whose objects cannot be created
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    // By the above line we can use the MAPPER as an instance to call the objects as the implemntations is already provided during
    // the compile time

    //mapping to userDto object
    UserDto mapToUserDto(User user);

    // vice-versa
    User mapToUser(UserDto userDto);

    //we just need to do this mapstruct will do these methods implementations automatically at the compile time
}
