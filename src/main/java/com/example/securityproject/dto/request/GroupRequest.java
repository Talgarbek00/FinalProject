package com.example.securityproject.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GroupRequest {
    @NotBlank
    private String groupName;
    @NotBlank
    private String dateOfStart;
    @NotBlank
    private String dateOfFinish;
}
