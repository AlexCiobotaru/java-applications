package com.Alex;

import java.util.ArrayList;

public class School {
    private String name;
    private String address;
    private ArrayList<Department> departmentList;
    private ArrayList<Student> studentList;

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        this.departmentList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }


    private int findStudent(String studentName){
        for(int i = 0; i < studentList.size(); i++){
            Student currentStudent = this.studentList.get(i);
            if(currentStudent.getName().equals(studentName))
                return i;
        }
        return -1;
    }


    private int findDepartment(String departmentName){
        for(int i = 0; i < departmentList.size(); i++){
            Department currentDepartment = this.departmentList.get(i);
            if(currentDepartment.getName().equals(departmentName))
                return i;
        }
        return -1;
    }

    public void addStudent(Student student){
        int foundPosition = findStudent(student.getName());
        if(foundPosition >= 0){
            System.out.println("The student is already on file");
            return;
        }

        studentList.add(student);
        System.out.println(student.toString());
    }

    public void removeStudent(String name){

        int position = findStudent(name) + 1;
        if(position <= 0){
            System.out.println("Student not found!");
            return;
        }

        for(int i = 0; i < studentList.size(); i++){
            Student currentStudent = this.studentList.get(i);
            if(currentStudent.getName().equals(name)){
                this.studentList.remove(currentStudent);
                System.out.println(currentStudent.getName() + " has been removed");

            }
        }
    }

    public Student getStudent(String name){
        for(int i = 0; i < studentList.size(); i++){
            Student currentStudent = this.studentList.get(i);
            if(currentStudent.getName().equals(name))
                return currentStudent;
        }
        return null;
    }

    public void addDepartment(Department department){
        int foundPosition = findDepartment(department.getName());
        if(foundPosition >= 0){
            System.out.println("The department is already on file");
            return;
        }

        departmentList.add(department);
        System.out.println("The department: " + department.getName() + " has been added");
    }

    public void removeDepartment(String name){

        int position = findDepartment(name);
        if(position <= 0){
            System.out.println("The department was not found!");
            return;
        }

        if(departmentList.isEmpty()){
            System.out.println("The department list is empty! Cannot delete from an empty list!");
            return;
        }

        for(int i = 0; i < departmentList.size(); i++){
            Department currentDepartment = this.departmentList.get(i);
            if(currentDepartment.getName().equals(name)){
                this.departmentList.remove(currentDepartment);
                System.out.println(currentDepartment.getName() + " has been removed");
            }

        }
    }

    public Department getDepartment(String name){
        for(int i = 0; i < departmentList.size(); i++){
            Department currentDepartment = this.departmentList.get(i);
            if(currentDepartment.getName().equals(name))
                return currentDepartment;
        }
        return null;
    }

    public void printStudents(){
        if(studentList.isEmpty()){
            System.out.println("Empty School!");
            return;
        }

        for(int i = 0; i < studentList.size(); i++)
            System.out.println((i+1) + "." + studentList.get(i).toString());
    }


    public void printDepartments(){
        for(int i = 0; i < departmentList.size(); i++){
            System.out.println((i+1) + "." + departmentList.get(i).toString());
        }
    }


}
