package com.Alex;


import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Instructor> instructorList;
    private ArrayList<Course> courseList;

    public Department() {
        this("Default Department");
    }

    public Department(String name) {
        this.name = name;
        this.instructorList = new ArrayList<>();
        this.courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private int findInstructor(Instructor instructor){
        return instructorList.indexOf(instructor);
    }

    private int findInstructor(String instructorName){
        for (int i = 0; i < instructorList.size(); i++){
            Instructor currentInstructor = this.instructorList.get(i);
            if(currentInstructor.getName().equals(instructorName))
                return i;
        }
        return -1;
    }

    public void addInstructor(Instructor instructor){

        int position = findInstructor(instructor.getName());

        if(position >= 0){
            System.out.println("The Instructor already exists!");
            return;
        }
        instructorList.add(instructor);
        System.out.println(instructor.toString() + " has been added!");
    }

    public Instructor getInstructor(String name){
        for(int i = 0; i < instructorList.size(); i++){
            Instructor instructor = this.instructorList.get(i);
            if(instructor.getName().equals(name))
                return instructor;
        }
        System.out.println("Instructor not found!");
        return null;
    }

    public void removeInstructor(Instructor instructor){
        int position = findInstructor(instructor) + 1;
        if(position < 0){
            System.out.println(instructor.getName() + " is not in the department!");
            return;
        }

        instructorList.remove(position);
        System.out.println("The instructor: " + instructor.toString() + " has been successfully deleted!");
    }

    public void printInstructors(){
        if(instructorList.isEmpty()){
            System.out.println("Empty List!");
        }

        for (int i = 0; i < instructorList.size();i++){
            System.out.println((i+1) + ".  " + instructorList.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Department: " + getName();
    }
}
