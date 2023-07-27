package com.alex.application.controller;

import com.alex.application.entity.Student;
import com.alex.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

//    @PutMapping("/edit/{studentId}")
//    // JSON update
//    public void updateStudent(@PathVariable("studentId") Long studentId,
//                              @RequestBody Student student) {
//        studentService.editStudent(studentId, student);
//    }

    @PutMapping("/edit/{studentId}")
    // Param update
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.editStudent(studentId, name, email);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }
}
