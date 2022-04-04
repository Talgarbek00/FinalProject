package com.example.securityproject.repositories;

import com.example.securityproject.models.Group;
import com.example.securityproject.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Query("select g from Group g where g.id=?1")
    Group getGroupById(Long groupId);

}
