package com.examly.springapp.service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepo courseRepo;
    
    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }
    
    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }
    
    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepo.findById(courseId);
    }
    
    @Override
    public Course updateCourse(Long courseId, Course course) {
        course.setCourseId(courseId);
        return courseRepo.save(course);
    }
    
    @Override
    public List<Course> getCoursesByInstructor(Long instructorId) {
        return courseRepo.findByInstructorInstructorId(instructorId);
    }
    
    @Override
    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }
}
