package com.example.securityproject.apis;

import com.example.securityproject.models.Response;
import com.example.securityproject.models.Student;
import com.example.securityproject.service.GroupService;
import com.example.securityproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentApi {

    private final StudentService studentService;
    private final GroupService groupService;

    @PostMapping("create/{groupId}")
    public Student registerNewStudent(@RequestBody Student student,
                                      @PathVariable Long groupId) {
        student.setGroup(groupService.getById(groupId));
        return studentService.register(student);
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("getById/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/delete/{studentId}")
    public Response deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteById(studentId);
    }

    @PutMapping("update/{studentId}")
    public Response updateStudent(@PathVariable Long studentId,
                                  @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }
}
