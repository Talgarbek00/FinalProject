package com.example.securityproject.service;

import com.example.securityproject.models.Group;
import com.example.securityproject.models.Response;

import java.util.List;

public interface GroupService {

    List<Group> getAll();

    Group getById(Long groupId);

    Group create(Group group);

    Response delete(Long groupId);

    Group update(Long groupId, Group group);

}
