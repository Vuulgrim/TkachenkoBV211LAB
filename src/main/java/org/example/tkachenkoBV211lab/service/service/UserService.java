package org.example.tkachenkoBV211lab.service.service;


import org.example.tkachenkoBV211lab.dto.UserDto;
import org.example.tkachenkoBV211lab.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    UserDto createUser(String fullName, LocalDate birthDate, String workplace);

    User getUserById(Long id);

    List<User> getAllUsers();

    UserDto getUserByIdDto(Long id);

    UserDto updateUser(Long id, String fullName, String workplace);

    void deleteUser(Long id);

}
