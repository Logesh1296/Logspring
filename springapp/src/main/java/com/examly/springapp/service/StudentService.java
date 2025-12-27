package com.examly.springapp.service;

import com.examly.springapp.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long studentId);
    Student updateStudent(Long studentId, Student student);
    Student getStudentByEmail(String email);
}
