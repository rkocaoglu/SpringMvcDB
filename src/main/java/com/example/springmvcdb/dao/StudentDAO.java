package com.example.springmvcdb.dao;

import com.example.springmvcdb.mysqldb.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();

    public Student getStudent(Long studentId);

    void saveStudent(Student theStudent);

    void deleteStudent(Student theStudent);
}
