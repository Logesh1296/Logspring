package com.examly.springapp.service;

import com.examly.springapp.model.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long courseId);
    Course updateCourse(Long courseId, Course course);
    List<Course> getCoursesByInstructor(Long instructorId);
    List<Course> getCoursesByLevel(String level);
}
