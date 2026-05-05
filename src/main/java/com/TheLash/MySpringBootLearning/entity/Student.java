package com.TheLash.MySpringBootLearning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Student")
@Getter
@Setter
public class Student {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="Student_Name")
    private String name;

    @Column(name="Mark")
    private Integer mark;
}
