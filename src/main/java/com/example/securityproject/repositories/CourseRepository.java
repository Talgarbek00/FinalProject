package com.example.securityproject.repositories;

import com.example.securityproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("select c from Course c where c.id= ?1")
    Course getCourseById(Long id);
}
