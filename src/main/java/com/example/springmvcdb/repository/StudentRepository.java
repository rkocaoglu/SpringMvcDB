package com.example.springmvcdb.repository;

import com.example.springmvcdb.mysqldb.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
