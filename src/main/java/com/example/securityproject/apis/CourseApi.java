package com.example.securityproject.apis;

import com.example.securityproject.models.Course;
import com.example.securityproject.models.Response;
import com.example.securityproject.service.CompanyService;
import com.example.securityproject.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course")
@AllArgsConstructor
public class CourseApi {

    private final CourseService courseService;
    private final CompanyService companyService;

    @PostMapping("/create/{companyId}")
    public Course create(@RequestBody Course course,
                         @PathVariable("companyId") Long companyId){
        course.setCompany(companyService.getById(companyId));
        return courseService.create(course);
    }

    @GetMapping()
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/getById/{courseId}")
    public Course getById(@PathVariable("courseId") Long courseId){
        return courseService.getById(courseId);
    }

    @DeleteMapping("/delete/{courseId}")
    public Response deleteById(@PathVariable("courseId") Long courseId){
        return courseService.deleteById(courseId);
    }

    @PutMapping("/update/{courseId}")
    public Course update(@RequestBody Course course,
                         @PathVariable("courseId") Long courseId){
        return courseService.updateCourse(course,courseId);
    }

}
