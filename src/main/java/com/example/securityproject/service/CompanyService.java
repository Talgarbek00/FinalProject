package com.example.securityproject.service;

import com.example.securityproject.models.Company;
import com.example.securityproject.models.Response;

import java.util.List;

public interface CompanyService {

    Response create(Company newCompany);

    List<Company> getAllCompany();

    Response deleteCompany(Long companyId);

    Company updateCompany(Long companyId, Company company);

    Company getById(Long companyId);

}
