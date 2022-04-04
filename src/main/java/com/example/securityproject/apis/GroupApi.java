package com.example.securityproject.apis;

import com.example.securityproject.models.Group;
import com.example.securityproject.models.Response;
import com.example.securityproject.service.CourseService;
import com.example.securityproject.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@AllArgsConstructor
public class GroupApi {

    private final GroupService groupService;
    private final CourseService courseService;

    @GetMapping()
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/getById/{groupId}")
    public Group getById(@PathVariable Long groupId) {
        return groupService.getById(groupId);
    }

    @PostMapping("/create/{courseId}")
    public Group create(@RequestBody Group group,
                        @PathVariable("courseId") Long courseId) {
        group.setCourse(courseService.getById(courseId));
        return groupService.create(group);
    }

    @DeleteMapping("/delete/{groupId}")
    public Response delete(@PathVariable Long groupId) {
        return groupService.delete(groupId);
    }

    @PutMapping("/update/{groupId}")
    public Group update(@PathVariable Long groupId,
                        @RequestBody Group group) {
        return groupService.update(groupId, group);
    }
}
