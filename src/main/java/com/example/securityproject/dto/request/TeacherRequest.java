package com.example.securityproject.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TeacherRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String email;
    @NotBlank
    private String lastName;
}
