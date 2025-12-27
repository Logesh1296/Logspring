package com.examly.springapp.service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    
    private InstructorRepo instructorRepo;
    public InstructorServiceImpl(InstructorRepo instructorRepo){
        this.instructorRepo=instructorRepo;
    }
    @Override
    public Instructor addInstructor(Instructor instructor) {
        if(instructor == null) return null;
        return instructorRepo.save(instructor);
    }
    
    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }
    
    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id).orElse(null);
    }
    
    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        Optional<Instructor> existingInstructor = instructorRepo.findById(id);
        if(!existingInstructor.isPresent()) {
            return null;
        }
        Instructor ins=existingInstructor.get();
        ins.setInstructorName(instructor.getInstructorName());
        ins.setEmail(instructor.getEmail());
        ins.setSpecialization(instructor.getSpecialization());
        ins.setPhoneNumber(instructor.getPhoneNumber());
        return instructorRepo.save(ins); 
    }

    @Override
    public boolean deleteInstructor(Long id) {
        if(instructorRepo.existsById(id)) {
            instructorRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Instructor> getInstructorsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return instructorRepo.findAll(pageable);
    }

    @Override
    public List<Instructor> getInstructorsBySpecialization(String specialization) {
        return instructorRepo.findBySpecialization(specialization);
    }
}