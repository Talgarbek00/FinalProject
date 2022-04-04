package com.example.securityproject.apis;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Teacher;
import com.example.securityproject.service.CourseService;
import com.example.securityproject.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/teacher")
public class TeacherApi {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @PostMapping("/create/{courseId}")
    public Teacher created(@RequestBody Teacher teacher,
                           @PathVariable Long courseId) {
        teacher.setCourse(courseService.getById(courseId));
        return teacherService.create(teacher);
    }

    @GetMapping()
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/getById/{teacherId}")
    public Teacher getById(@PathVariable Long teacherId) {
        return teacherService.getById(teacherId);
    }

    @DeleteMapping("/delete/{teacherId}")
    public Response delete(@PathVariable Long teacherId) {
        return teacherService.delete(teacherId);
    }

    @PutMapping("/update/{teacherId}")
    public Teacher update(@PathVariable Long teacherId,
                          @RequestBody Teacher teacher) {
        return teacherService.update(teacherId, teacher);
    }
}
