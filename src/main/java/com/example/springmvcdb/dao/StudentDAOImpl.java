package com.example.springmvcdb.dao;

import com.example.springmvcdb.mysqldb.Student;
import com.example.springmvcdb.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteStudent(Student theStudent) {
        studentRepository.delete(theStudent);
    }
}
