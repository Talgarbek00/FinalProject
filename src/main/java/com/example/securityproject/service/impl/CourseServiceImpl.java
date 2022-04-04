package com.example.securityproject.service.impl;

import com.example.securityproject.models.Course;
import com.example.securityproject.models.Response;
import com.example.securityproject.repositories.CourseRepository;
import com.example.securityproject.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    @Override
    public Course create(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @Override
    public Course getById(Long id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }

    @Override
    public Response deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
        String massage = String.format("successfully deleted");
        return Response.builder()
                .status(HttpStatus.OK)
                .massage(massage)
                .build();
    }

    @Override
    public Course updateCourse(Course newCourse, Long courseId) {

        Course course = courseRepository.getCourseById(courseId);

        String courseName = course.getCourseName();

        String newCourseName = newCourse.getCourseName();

        if (!Objects.equals(courseName, newCourseName)) {
            course.setCourseName(newCourseName);
        }

        String duration = course.getDuration();

        String newDuration = newCourse.getDuration();

        if (!Objects.equals(duration, newDuration)) {
            course.setDuration(newDuration);
        }
        return course;
    }

}
