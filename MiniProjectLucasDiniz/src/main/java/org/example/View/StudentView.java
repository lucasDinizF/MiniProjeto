package org.example.View;

import org.example.Controller.StudentController;

import java.util.Scanner;

public class StudentView {
    private final StudentController studentController;
    private final Scanner sc;

    public StudentView() {
        this.studentController = new StudentController();
        this.sc = new Scanner(System.in);
    }

    public void displayStudentMenu() {
        System.out.println("1. List students in the 'History' discipline (in-person modality)");
        System.out.println("2. View student details by ID");
        System.out.println("3. View student details by name");


    }

    public void listHistoryInPersonStudents() {
        String response = studentController.listInPersonHistoryStudents();
        System.out.println(response);
    }

    public void viewStudentDetailsById() {
        System.out.print("Enter the student's ID: ");
        int id = sc.nextInt();
        String response = studentController.findStudentById(id);
        System.out.println(response);

    }

    public void viewStudentDetailsByName() {
        System.out.print("Enter the student's name: ");
        sc.nextLine();
        String name = sc.nextLine();
        String response = studentController.findStudentByName(name);
        System.out.println(response);
    }
}

