package com.Alex;

import java.util.Scanner;

/**
 * Console application that allows the user to manage a High School - add, delete or display departments, courses and students.
 * Note that some validation is implemented in order to avoid duplication of data.
 *The application uses Collections( e.g. ArrayList), the encapsulation principle in order to hide the
 * inner functionality from the user, as well as the inheritance principle(see Person, Student and Instructor classes).
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static School school = new School("Decebal HighSchool", "B-dul Decebal, nr 19");
    private static Department department = new Department();

    public static void main(String[] args) {
	    boolean quit = false;
        printMenu();

	    while(!quit){
            System.out.println("Enter your choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine();

	        switch (choice){
                case 0:
                    printMenu();
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    getStudent();
                    break;
                case 4:
                    printStudents();
                    break;
                case 5:
                    addInstructor();
                    break;
                case 6:
                    removeInstructor();
                    break;
                case 7:
                    getInstructor();
                    break;
                case 8:
                    printInstructors();
                    break;
                case 9:
                    addDepartment();
                    break;
                case 10:
                    removeDepartment();
                    break;
                case 11:
                    getDepartment();
                    break;
                case 12:
                    printDepartments();
                    break;
                  case 13:
                      quit = true;
                      System.out.println("EXIT!");
                      break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("Press: \n");
        System.out.println("0 - To print the menu");
        System.out.println("1 - To add a student");
        System.out.println("2 - To remove a student");
        System.out.println("3 - To retrieve a student");
        System.out.println("4 - To print students");
        System.out.println("5 - To add an instructor");
        System.out.println("6 - To remove an instructor");
        System.out.println("7 - To retrieve an instructor");
        System.out.println("8 - To print instructors");
        System.out.println("9 - To add a department");
        System.out.println("10 - To remove a department");
        System.out.println("11 - To retrieve a department");
        System.out.println("12 - To print departments");
        System.out.println("13 - To exit the app");
    }

    private static void addStudent(){
        System.out.println("Enter the full name of the student: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter the address of the student: ");
        String studentAddress = scanner.nextLine();
        System.out.println("Enter the index number of the student: ");
        long studentIndex = scanner.nextLong();
        scanner.nextLine();

        school.addStudent(new Student(studentName,studentAddress,studentIndex));

    }

    private static void removeStudent(){
        System.out.println("Enter the full name of the student to be removed: ");
        String removedStudent = scanner.nextLine();
        school.removeStudent(removedStudent);
    }
    private static void printStudents(){
        school.printStudents();
    }

    private static void getStudent(){
        System.out.println("Enter the full name of the student");
        String studentName = scanner.nextLine();

        System.out.println(school.getStudent(studentName).toString());

    }

    private static void addInstructor(){

        System.out.println("Enter the name of the instructor");
        String instructorName = scanner.nextLine();
        System.out.println("Enter the address of the instructor");
        String instructorAddress = scanner.nextLine();
        System.out.println("Enter the index number of the instructor");
        String instructorIndex = scanner.nextLine();

        Instructor instructor = new Instructor(instructorName, instructorAddress, instructorIndex);
        department.addInstructor(instructor);
    }

    private static void removeInstructor(){
        System.out.println("Enter the name of the instructor to be removed: ");
        String name = scanner.nextLine();

    }

    private static void getInstructor(){
        System.out.println("Enter the name of the instructor to be retrieved: ");
        String name = scanner.nextLine();

        Object instructor = department.getInstructor(name);
        System.out.println(instructor.toString());

    }

    private static void printInstructors(){
        department.printInstructors();
    }

    private static void addDepartment(){
        System.out.println("Enter the name of the department: ");
        String depName = scanner.nextLine();

        school.addDepartment(new Department(depName));
    }

    private static void removeDepartment(){
        System.out.println("Enter the name of the department to be removed: ");
        String department = scanner.nextLine();

        school.removeDepartment(department);
    }

    private static void getDepartment(){
        System.out.println("Enter the name of the department: ");
        String depName = scanner.nextLine();

        System.out.println(school.getDepartment(depName) + "has been retrieved!");
    }

    private static void printDepartments(){
        school.printDepartments();
    }
}
