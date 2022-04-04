package com.example.securityproject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponse {
    private long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}
