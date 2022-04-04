package com.example.securityproject.service;

import com.example.securityproject.models.Course;
import com.example.securityproject.models.Group;
import com.example.securityproject.models.Response;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    Course create(Course course);

    Course getById(Long id);

    Response deleteById(Long courseId);

    Course updateCourse(Course course, Long courseId);

}
