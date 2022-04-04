package com.example.securityproject.mapper.editMapper;

import com.example.securityproject.dto.request.CompanyRequest;
import com.example.securityproject.models.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEditMapper {
    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }

        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        System.out.println("Company EditMapper");
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        System.out.println("Company EditMapper |Update|");
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
