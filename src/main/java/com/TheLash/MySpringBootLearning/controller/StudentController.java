package com.TheLash.MySpringBootLearning.controller;

import com.TheLash.MySpringBootLearning.entity.Student;
import com.TheLash.MySpringBootLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Student> all = studentService.getAll();
        if(!all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student newStudent){
        try {
            studentService.saveEntry(newStudent);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Student> student =  studentService.getById(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delById(@PathVariable Long id){
        try {
            studentService.delById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Student updatedStudent){
        Student student = studentService.getById(id).orElse(null);
        if(student != null){
            student.setName(updatedStudent.getName()!=null && !updatedStudent.getName().isEmpty() ? updatedStudent.getName() : student.getName());
            student.setMark(updatedStudent.getMark() < 100 && updatedStudent.getMark() >= 0 ? updatedStudent.getMark() : student.getMark());
            studentService.saveEntry(student);
            return new ResponseEntity<>(student, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}