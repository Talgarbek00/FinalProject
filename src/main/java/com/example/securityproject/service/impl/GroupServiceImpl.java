package com.example.securityproject.service.impl;

import com.example.securityproject.models.Group;
import com.example.securityproject.models.Response;
import com.example.securityproject.repositories.GroupRepository;
import com.example.securityproject.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getById(Long groupId) {
        Group group = groupRepository.getGroupById(groupId);
        return group;
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    @Transactional
    public Response delete(Long groupId) {
        groupRepository.deleteById(groupId);
        return Response.builder()
                .status(HttpStatus.OK)
                .massage(String.format("group with id:%s deleted",groupId))
                .build();
    }

    @Override
    public Group update(Long groupId, Group newGroup) {
        Group group = groupRepository.getGroupById(groupId);
        group.setGroupName(newGroup.getGroupName());
        group.setDateOfStart(newGroup.getDateOfStart());
        group.setDateOfFinish(newGroup.getDateOfFinish());
        return group;
    }
}
