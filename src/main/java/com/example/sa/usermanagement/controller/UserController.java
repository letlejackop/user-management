package com.example.sa.usermanagement.controller;

import com.example.sa.usermanagement.dto.UserRequestDto;
import com.example.sa.usermanagement.dto.UserResponseDto;
import com.example.sa.usermanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("user-management/v1/")
public class UserController {


    private final UserService userService;


    @PostMapping("users")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) {

        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);

    }

    @GetMapping("users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {

        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto request) {
        return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.ACCEPTED);

    }
}
