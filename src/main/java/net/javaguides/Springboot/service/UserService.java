package net.javaguides.Springboot.service;

import net.javaguides.Springboot.dto.UserDto;
import net.javaguides.Springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userid);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
