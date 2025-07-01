package net.javaguides.Springboot.mapper;

import net.javaguides.Springboot.dto.UserDto;
import net.javaguides.Springboot.entity.User;

public class UserMapper {
    // this method converts the user object to user dto that is jpa to dto
    public static UserDto mapToUserDto(User user)
    {
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());

        return userDto;
    }

    // this method converts the dto object to jpa entity

    public static User mapToUser(UserDto userDto)
    {
        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return user;
    }
}
