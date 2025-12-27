package com.examly.springapp.service;

import com.examly.springapp.model.Enrollment;
import com.examly.springapp.repository.EnrollmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    
    private EnrollmentRepo enrollmentRepo;
    
    public EnrollmentServiceImpl(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }
    
    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        if(enrollment == null) return null;
        return enrollmentRepo.save(enrollment);
    }
    
    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }
    
    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepo.findById(id).orElse(null);
    }
    
    @Override
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
        Optional<Enrollment> existingEnrollment = enrollmentRepo.findById(id);
        if(!existingEnrollment.isPresent()) {
            return null;
        }
        Enrollment e = existingEnrollment.get();
        e.setCourseId(enrollment.getCourseId());
        e.setStudentId(enrollment.getStudentId());
        return enrollmentRepo.save(e);
    }
    
    @Override
    public boolean deleteEnrollment(Long id) {
        if(enrollmentRepo.existsById(id)) {
            enrollmentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
