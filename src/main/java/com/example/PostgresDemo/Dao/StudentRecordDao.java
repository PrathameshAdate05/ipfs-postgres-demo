package com.example.PostgresDemo.Dao;

import com.example.PostgresDemo.Entity.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRecordDao extends JpaRepository<StudentRecord, String> {
}
