package com.examly.springapp.service;

import com.examly.springapp.model.Instructor;
import org.springframework.data.domain.Page;
import java.util.List;

public interface InstructorService {
    Instructor addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    Instructor updateInstructor(Long id, Instructor instructor);
    boolean deleteInstructor(Long id);
    Page<Instructor> getInstructorsPaginated(int page, int size);
    List<Instructor> getInstructorsBySpecialization(String specialization);
}
