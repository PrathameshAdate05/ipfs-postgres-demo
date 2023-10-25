package com.example.PostgresDemo.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student_record")
public class StudentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    Integer student_id;

    String hash;
}
