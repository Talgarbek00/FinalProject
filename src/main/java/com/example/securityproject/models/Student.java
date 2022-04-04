package com.example.securityproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    private String firstName;
    private String email;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private EnumStudyFormat studyFormat;


    @ManyToOne(cascade = {MERGE,REFRESH,DETACH,PERSIST})
    @JsonIgnore
    private Group group;

//    @PreRemove
//    public void removeGroupFromStudent(){
//        group.getStudent().remove(this);
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyFormat=" + studyFormat +
                '}';
    }
}

