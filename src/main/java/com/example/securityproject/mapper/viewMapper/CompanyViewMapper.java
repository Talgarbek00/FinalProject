package com.example.securityproject.mapper.viewMapper;

import com.example.securityproject.dto.response.CompanyResponse;
import com.example.securityproject.models.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {
    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }

        CompanyResponse response = new CompanyResponse();
        if (company.getId() != null) {
            response.setId(company.getId());
        }

        response.setCompanyName(company.getCompanyName());
        response.setLocatedCountry(company.getLocatedCountry());
        System.out.println("Company ViewMapper");
        return response;
    }

    public List<CompanyResponse> viewCompanies(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company c : companies) {
            responses.add(viewCompany(c));
        }
        return responses;
    }
}
