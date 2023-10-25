package com.example.PostgresDemo.Controller;

import com.example.PostgresDemo.Entity.Student;

import com.example.PostgresDemo.Service.StudentRecordService;
import com.example.PostgresDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    StudentRecordService studentRecordService;


    @PostMapping("/save")
    public String save(@RequestBody Student student){


       String res = studentRecordService.insertFile(student);
       return res;
    }

//    @GetMapping("/getAll")
//    public List<Student> getAllData(){
//        return studentService.getAllData();
//    }
}
