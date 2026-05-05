package com.TheLash.MySpringBootLearning.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JournalEntry {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Title")
    private String title;

    @Column(name="Content")
    private String content;

}
