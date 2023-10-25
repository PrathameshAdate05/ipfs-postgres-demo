package com.example.PostgresDemo.Service;

import com.example.PostgresDemo.Entity.Student;

public interface StudentRecordServiceImpl {

    public String insertFile(Student student);
    public Student getStudentFromHash(String id);
}
