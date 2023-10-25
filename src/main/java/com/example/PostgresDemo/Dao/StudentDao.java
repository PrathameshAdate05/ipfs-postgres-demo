package com.example.PostgresDemo.Dao;

import com.example.PostgresDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
