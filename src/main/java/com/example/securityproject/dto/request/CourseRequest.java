package com.example.securityproject.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CourseRequest {
    @NotBlank
    private String courseName;

    @NotBlank
    private String duration;
}
