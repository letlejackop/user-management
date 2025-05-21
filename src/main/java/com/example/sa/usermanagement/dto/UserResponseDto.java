package com.example.sa.usermanagement.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private String createdAt;
}
