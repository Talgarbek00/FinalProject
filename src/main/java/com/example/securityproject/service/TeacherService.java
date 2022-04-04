package com.example.securityproject.service;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher create(Teacher teacher);

    List<Teacher> getAll();

    Teacher getById(Long teacherId);

    Response delete(Long teacherId);

    Teacher update(Long teacherId, Teacher teacher);

}
