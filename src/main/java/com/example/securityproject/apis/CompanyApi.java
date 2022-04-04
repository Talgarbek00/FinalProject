package com.example.securityproject.apis;

import com.example.securityproject.models.Company;
import com.example.securityproject.models.Response;
import com.example.securityproject.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@AllArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @PostMapping("/create")
    public Response createCompany(@RequestBody Company newCompany) {
        return companyService.create(newCompany);
    }

    @GetMapping()
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @DeleteMapping("/delete/{companyId}")
    public Response deleteCompany(@PathVariable Long companyId) {
        return companyService.deleteCompany(companyId);
    }

    @PutMapping("/update/{companyId}")
    public Company updateCompany(@PathVariable Long companyId,
                                 @RequestBody Company company) {
        return companyService.updateCompany(companyId, company);
    }

    @GetMapping("/getById/{companyId}")
    private Company getById(@PathVariable Long companyId) {
        return companyService.getById(companyId);
    }
}
