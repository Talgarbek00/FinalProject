package com.example.securityproject.repositories;

import com.example.securityproject.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("select case when count (s) > 0 then true else false end "
            +"from Company s where s.companyName = ?1")
    boolean existsByName(String companyName);

    @Query("select s from Company s where s.id = ?1")
    Company getCompanyById(Long companyId);

}
