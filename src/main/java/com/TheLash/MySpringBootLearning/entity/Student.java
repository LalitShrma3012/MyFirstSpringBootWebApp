package com.TheLash.MySpringBootLearning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="Student_Name")
    private String name;

    @Column(name="Mark")
    private Integer mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
