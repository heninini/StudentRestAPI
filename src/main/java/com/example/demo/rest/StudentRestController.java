package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> thestudent;

    @PostConstruct
    public  void loadData(){
        thestudent= new  ArrayList<>();
        thestudent.add(new Student("henos","Ghirmay"));
        thestudent.add(new Student("samuel","feshia"));
        thestudent.add(new Student("hello", "world"));
    }
    @GetMapping("/student")
    public List<Student> getStudents(){


        return thestudent;

    }
//    getting single student using the index
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
//        throw exception
       if(studentId> thestudent.size()||studentId<0){
           throw new StudentNotFoundException("Student ID not found exception "+ studentId);
       }
        return thestudent.get(studentId);

    }

}