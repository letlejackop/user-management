package com.example.sa.usermanagement.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequestDto {
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "email must not be empty")
    private String email;
    @NotEmpty(message = "createdAt must not be empty")
    private String createdAt;
}
