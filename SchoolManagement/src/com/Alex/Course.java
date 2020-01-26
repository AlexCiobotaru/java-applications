package com.Alex;

import java.util.ArrayList;

public class Course {

    private String name;
    private String courseID;
    private Instructor instructor;
    private ArrayList<Student> studentList;

    public Course(){
    }

    public Course(String name, String courseID) {
        this.name = name;
        this.courseID = courseID;
        this.instructor = new Instructor();
        this.studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCourseID() {
        return courseID;
    }
}
