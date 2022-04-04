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
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;


    @ManyToMany(cascade = {MERGE,DETACH,PERSIST,REFRESH}
                ,mappedBy = "groupList")
    @JsonIgnore
    private List<Course> courseList;

    @OneToMany(cascade = ALL,mappedBy = "group")
    private List<Student> student;

//    @PreRemove
//    public void removeCourseFromGroup() {
//        for (Course c : courseList) {
//            c.getGroupList().remove(this);
//        }
//    }

    public void setCourse(Course course) {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        courseList.add(course);
        course.setGroup(this);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dateOfStart='" + dateOfStart + '\'' +
                ", dateOfFinish='" + dateOfFinish + '\'' +
                '}';
    }
}

