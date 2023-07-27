package com.alex.application.service;

import com.alex.application.entity.Student;
import com.alex.application.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student doesn't exist"));
    }

    @Transactional
    public void addStudent(Student student) {
        studentRepository
                .findStudentByEmail(student.getEmail())
                .orElseThrow(() -> new IllegalStateException("Email taken"));

        studentRepository.save(student);
    }

    @Transactional
    public void delete(Long studentId) {
        studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student doesn't exist"));

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void editStudent(Long studentId, Student student) {
        studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student doesn't exist"));

        Student updateStudent = studentRepository.findById(studentId).get();
        updateStudent.setId(studentId);
        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setDob(student.getDob());
        studentRepository.save(updateStudent);
    }

    @Transactional
    public void editStudent(Long studentId, String name, String email) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student doesn't exist"));

        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {

            student.setName(name);
        }

        if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)) {
            if (studentRepository
                    .findStudentByEmail(email)
                    .isPresent()) {

                throw new IllegalStateException("Email taken");
            }

            student.setEmail(email);
        }
    }
}
