package com.example.sa.usermanagement.service;

import com.example.sa.usermanagement.dto.UserRequestDto;
import com.example.sa.usermanagement.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);

    String deleteUser(Long id);
}
