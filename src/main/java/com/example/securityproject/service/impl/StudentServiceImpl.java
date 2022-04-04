package com.example.securityproject.service.impl;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Student;
import com.example.securityproject.repositories.StudentRepository;
import com.example.securityproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student register(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Response deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
        return Response.builder()
                .status(HttpStatus.OK)
                .massage(String.format("student with id:%s deleted",studentId))
                .build();
    }

    @Override
    public Response updateStudent(Long studentId, Student newStudent) {
        Student student = studentRepository.getStudentById(studentId);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());
        student.setStudyFormat(newStudent.getStudyFormat());
        return Response.builder()
                .status(HttpStatus.OK)
                .massage(String.format("updated successfully"))
                .build();
    }
}
