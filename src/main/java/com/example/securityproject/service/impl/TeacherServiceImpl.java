package com.example.securityproject.service.impl;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Teacher;
import com.example.securityproject.repositories.TeacherRepository;
import com.example.securityproject.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Long teacherId) {
        Teacher teacher = teacherRepository.getById(teacherId);
        return teacher;
    }

    @Override
    public Response delete(Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return Response.builder()
                .status(HttpStatus.OK)
                .massage(String.format("teacher with id:%s deleted",teacherId))
                .build();
    }

    @Override
    public Teacher update(Long teacherId, Teacher newTeacher) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        teacher.setFirstName(newTeacher.getFirstName());
        teacher.setLastName(newTeacher.getLastName());
        teacher.setEmail(newTeacher.getEmail());
        return teacher;
    }


}
