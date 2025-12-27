package com.examly.springapp.service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepo studentRepo;
    
    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }
    
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    
    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }
    
    @Override
    public Student updateStudent(Long studentId, Student student) {
        student.setStudentId(studentId);
        return studentRepo.save(student);
    }
    
    @Override
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
