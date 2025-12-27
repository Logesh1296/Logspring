package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    
    private InstructorService iS; 
    public InstructorController(InstructorService iS){
        this.iS=iS;
    }
    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody(required = false) Instructor instructor) {
        if(instructor == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Instructor ins=iS.addInstructor(instructor);
        if(ins==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ins,HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors=iS.getAllInstructors();
        if(instructors==null || instructors.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(instructors,HttpStatus.OK);
    }
    
    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long instructorId) {
        Instructor ins=iS.getInstructorById(instructorId);
        if(ins==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ins,HttpStatus.OK);
    }
    
    @PutMapping("/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long instructorId, @RequestBody Instructor instructor) {
        Instructor ins=iS.updateInstructor(instructorId, instructor);
        if(ins==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ins,HttpStatus.OK);
    }
    
    @DeleteMapping("/{instructorId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long instructorId) {
        boolean deleted = iS.deleteInstructor(instructorId);
        if(!deleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> getInstructorsPaginated(@PathVariable int page, @PathVariable int size) {
        Page<Instructor> instructors = iS.getInstructorsPaginated(page, size);
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> getInstructorsBySpecialization(@PathVariable String specialization) {
        List<Instructor> instructors = iS.getInstructorsBySpecialization(specialization);
        if(instructors.isEmpty()) {
            return new ResponseEntity<>("No instructors found with specialization: " + specialization, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }
}
