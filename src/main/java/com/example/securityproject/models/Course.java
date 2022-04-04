package com.example.securityproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {MERGE,PERSIST,DETACH,REFRESH})
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = {MERGE,PERSIST,DETACH,REFRESH,REMOVE})
    @JoinTable(name = "groups_courses"
            , joinColumns = @JoinColumn(name = "courseId")
            , inverseJoinColumns = @JoinColumn(name = "groupId"))
    private List<Group> groupList;

    @OneToOne(cascade = ALL,mappedBy = "course")
    private Teacher teacher;

    @JsonIgnore
    public void setGroup(Group group) {
        if (groupList == null) {
            groupList = new ArrayList<>();
        }
        groupList.add(group);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
