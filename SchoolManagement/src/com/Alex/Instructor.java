package com.Alex;

public class Instructor extends Person {
    private String instructorID;
    private Course course;

    public Instructor(){

    }

    public Instructor(String name, String address, String instructorID) {
        super(name, address);
        this.instructorID = instructorID;
        this.course = new Course();
    }



    public String getInstructorID() {
        return instructorID;
    }

    @Override
    public String toString() {
         return "#" + instructorID + " " + getName() + " -> " + getAddress();
    }
}
