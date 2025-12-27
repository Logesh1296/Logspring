package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    private Long courseId;
    private Long studentId;

    public Enrollment() {}

    public Long getEnrollmentId(){
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId){
        this.enrollmentId=enrollmentId;
    }

    public Long getCourseId(){
        return courseId;
    }

    public void setCourseId(Long courseId){
        this.courseId=courseId;
    }

    public Long getStudentId(){
        return studentId;
    }

    public void setStudentId(Long studentId){
        this.studentId=studentId;
    }
}
