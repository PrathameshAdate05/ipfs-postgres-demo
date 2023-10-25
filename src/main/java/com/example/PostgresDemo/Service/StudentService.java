package com.example.PostgresDemo.Service;

import com.example.PostgresDemo.Dao.StudentDao;
import com.example.PostgresDemo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceImpl{

    @Autowired
    StudentDao studentDao;


    @Override
    public boolean saveData(Student student) {
        Student temp = studentDao.save(student);

        if (temp != null)
            return true;
        return false;
    }

    @Override
    public List<Student> getAllData() {
        return studentDao.findAll();
    }
}
