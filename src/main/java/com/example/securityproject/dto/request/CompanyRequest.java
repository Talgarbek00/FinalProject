package com.example.securityproject.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CompanyRequest {

    @NotBlank
    private String companyName;

    @NotBlank
    private String locatedCountry;

}
