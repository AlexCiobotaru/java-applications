package com.Alex;

public class Student extends Person {
    private long studentID;
    private Course course;

    public Student(String name, String address, long studentID) {
        super(name, address);
        this.studentID = studentID;
        this.course = new Course();
    }

    public long getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "#" + studentID + " " + getName() + " -> " + getAddress();
    }
}
