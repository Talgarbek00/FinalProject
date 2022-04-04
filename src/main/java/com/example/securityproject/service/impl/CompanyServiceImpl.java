package com.example.securityproject.service.impl;

import com.example.securityproject.models.Company;
import com.example.securityproject.models.Response;
import com.example.securityproject.repositories.CompanyRepository;
import com.example.securityproject.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Response create(Company newCompany) {

        String companyName = newCompany.getCompanyName();

        boolean exists = companyRepository.existsByName(companyName);

        if (exists){
            throw new RuntimeException("company with name "+ companyName +" already exist");
        }

        Company company = companyRepository.save(newCompany);

        return Response.builder()
                .status(HttpStatus.CREATED)
                .massage(String.format("%s is successfully created",company))
                .build();
    }

    @Override
    public List<Company> getAllCompany()  {
        List<Company> companyList = companyRepository.findAll();
        return companyList;
    }

    @Override
    public Response deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(RuntimeException::new);
        log.info("company = {}", company.getCompanyName());
        companyRepository.deleteById(companyId);

        return Response.builder()
                .status(HttpStatus.OK)
                .massage(String.format("successfully deleted"))
                .build();
    }

    @Override
    @Transactional
    public Company updateCompany(Long companyId, Company newCompany) {

        Company company = companyRepository.getCompanyById(companyId);

            company.setCompanyName(newCompany.getCompanyName());
            company.setLocatedCountry(newCompany.getLocatedCountry());

        return company;
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.getCompanyById(companyId);
    }

}
