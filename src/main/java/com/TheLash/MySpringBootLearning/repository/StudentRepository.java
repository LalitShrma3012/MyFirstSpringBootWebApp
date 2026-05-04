package com.TheLash.MySpringBootLearning.repository;

import com.TheLash.MySpringBootLearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
