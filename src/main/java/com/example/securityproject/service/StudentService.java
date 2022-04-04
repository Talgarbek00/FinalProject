package com.example.securityproject.service;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Student;

import java.util.List;

public interface StudentService {
    Student register(Student student);

    List<Student> getAllStudents();

    Student getById(Long id);

    Response deleteById(Long studentId);

    Response updateStudent(Long studentId, Student student);

}
