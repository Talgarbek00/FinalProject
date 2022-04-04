package com.example.securityproject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private long id;
    private String firstName;
    private String email;
    private String lastName;
}
