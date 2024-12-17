package org.example.tkachenkoBV211lab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.UserDto;
import org.example.tkachenkoBV211lab.entity.User;
import org.example.tkachenkoBV211lab.repository.UserRepository;
import org.example.tkachenkoBV211lab.service.service.UserService;
import org.example.tkachenkoBV211lab.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(String fullName, LocalDate birthDate, String workplace) {
        User user = new User();
        user.setFullName(fullName);
        user.setBirthDate(birthDate);
        user.setWorkplace(workplace);
        user.setMonthlyIncome((int)(Math.random() * 10_000));
        user.setCreditRating((user.getMonthlyIncome() / 1000) * 100);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User repository not found with id " + id));
    }

    @Override
    public UserDto getUserByIdDto(Long id) {
        return userMapper.toDto(getUserById(id));
    }

    @Override
    public UserDto updateUser(Long id, String fullName, String workplace) {
        User user = getUserById(id);
        user.setFullName(fullName);
        user.setWorkplace(workplace);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}