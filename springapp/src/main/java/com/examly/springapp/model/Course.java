package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String description;
    private Integer duration;
    private Double price;
    private String level;
    
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(){}

    public Long getCourseId(){
        return courseId;
    }

    public void setCourseId(Long courseId){
        this.courseId=courseId;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public Integer getDuration(){
        return duration;
    }

    public void setDuration(Integer duration){
        this.duration=duration;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price=price;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(String level){
        this.level=level;
    }

    public Instructor getInstructor(){
        return instructor;
    }

    public void setInstructor(Instructor instructor){
        this.instructor=instructor;
    }
}
