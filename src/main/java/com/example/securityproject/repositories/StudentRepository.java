package com.example.securityproject.repositories;

import com.example.securityproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.id=?1")
    Student getStudentById(Long id);
}
