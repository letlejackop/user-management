package com.example.sa.usermanagement.service.serviceImpl;

import com.example.sa.usermanagement.dto.UserRequestDto;
import com.example.sa.usermanagement.dto.UserResponseDto;
import com.example.sa.usermanagement.entity.User;
import com.example.sa.usermanagement.exception.ResourceNotFoundException;
import com.example.sa.usermanagement.repo.UserRepository;
import com.example.sa.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User createdUser = userRepository.save(mapRequestToEntity(userRequestDto));
        return mapEntityToResponse(createdUser);
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        return mapEntityToResponse(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll().stream().toList();

        return mapEntityListToResponse(users);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {

        User user = userRepository.findById(id).map(result -> {
            mapRequestToEntity(result, userRequestDto);

            return userRepository.save(result);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        return mapEntityToResponse(user);
    }

    @Override
    public String deleteUser(Long id) {

        userRepository.deleteById(id);
        return "User Deleted Successfully with ID: " + id;
    }

    public User mapRequestToEntity(UserRequestDto userRequestDto) {

        if (userRequestDto == null) {
            return null;
        }

        return User.builder()
                .name(userRequestDto.getName())
                .createdAt(userRequestDto.getCreatedAt())
                .email(userRequestDto.getEmail())
                .build();
    }

    public User mapRequestToEntity(User user, UserRequestDto userRequestDto) {

        if (userRequestDto == null) {
            return null;
        }

        user.setName(userRequestDto.getName());
        user.setCreatedAt(userRequestDto.getCreatedAt());
        user.setEmail(userRequestDto.getEmail());

        return user;
    }

    public UserResponseDto mapEntityToResponse(User user) {
        if (user == null) {
            return null;
        }

        return UserResponseDto.builder().id(user.getId()).name(user.getName()).createdAt(user.getCreatedAt()).email(user.getEmail()).build();
    }

    public List<UserResponseDto> mapEntityListToResponse(List<User> users) {

        if (users == null) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<>();
        for (User user1 : users) {
            list.add(mapEntityToResponse(user1));
        }

        return list;

    }

}
