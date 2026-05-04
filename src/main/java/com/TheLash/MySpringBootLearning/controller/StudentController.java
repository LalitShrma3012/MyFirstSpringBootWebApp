package com.TheLash.MySpringBootLearning.controller;

import com.TheLash.MySpringBootLearning.entity.Student;
import com.TheLash.MySpringBootLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public boolean createStudent(@RequestBody Student newStudent){
        studentService.saveEntry(newStudent);
        return true;
    }

    @GetMapping("/id/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getById(id).orElse(null);
    }

    @DeleteMapping("/id/{id}")
    public boolean delById(@PathVariable Long id){
        studentService.delById(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public boolean updateById(@PathVariable Long id, @RequestBody Student updatedStudent){
        Student student = studentService.getById(id).orElse(null);
        if(student != null){
            student.setName(updatedStudent.getName()!=null && !updatedStudent.getName().isEmpty() ? updatedStudent.getName() : student.getName());
            student.setMark(updatedStudent.getMark() < 100 && updatedStudent.getMark() >= 0 ? updatedStudent.getMark() : student.getMark());
        }
        studentService.saveEntry(student);
        return true;
    }

}