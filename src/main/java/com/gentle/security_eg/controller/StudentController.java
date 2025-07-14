package com.gentle.security_eg.controller;

import com.gentle.security_eg.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> studentsList = new ArrayList<>(List.of(
            new Student(1, "Bassell", 88),
            new Student(1, "Derrick", 65),
            new Student(1, "Emily", 78),
            new Student(1, "Jason", 28),
            new Student(1, "Mark", 38),
            new Student(1, "Sharon", 48)
    ));

    @GetMapping()
    public List<Student> getStudents() {
        return studentsList;
    }

    @GetMapping("/get-csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        studentsList.add(student);
        return student;
    }
}
