package com.example.springmvcdb.controller;

import com.example.springmvcdb.dao.StudentDAO;
import com.example.springmvcdb.mysqldb.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    @RequestMapping("/list")
    public String listStudents(Model theModel) {
        theModel.addAttribute("students", studentDAO.getStudents());
        return "list-students";
    }

    @RequestMapping("/showStudentForm")
    public String showStudent(Model theModel) {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "student-form";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student theStudent) {
        studentDAO.saveStudent(theStudent);
        return "redirect:/student/list";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam Long studentId, Model theModel) {
        Student student = studentDAO.getStudent(studentId);
        theModel.addAttribute("student", student);
        return "student-form";

    }

    @RequestMapping(value = "/deleteStudent")
    public String deleteStudent(@RequestParam Long studentId) {
        Student student = studentDAO.getStudent(studentId);
        studentDAO.deleteStudent(student);
        return "redirect:/student/list";

    }
}
