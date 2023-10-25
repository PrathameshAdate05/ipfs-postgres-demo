package com.example.PostgresDemo.Service;

import com.example.PostgresDemo.Entity.Student;

import java.util.List;

public interface StudentServiceImpl {
    public boolean saveData(Student student);

    public List<Student> getAllData();
}
