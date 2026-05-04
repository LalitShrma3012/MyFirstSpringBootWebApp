package com.TheLash.MySpringBootLearning.service;

import com.TheLash.MySpringBootLearning.entity.Student;
import com.TheLash.MySpringBootLearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void saveEntry(Student newStudent){
        studentRepository.save(newStudent);
    }


    public Optional<Student> getById(Long id){
        return studentRepository.findById(id);
    }

    public void delById(Long id){
        studentRepository.deleteById(id);
    }
}
