package org.example.View;

import org.example.Controller.EnrollmentController;
import org.example.Controller.DisciplineController;

import java.util.Scanner;

public class EnrollmentView {
    private EnrollmentController enrollmentController;
    private DisciplineController disciplineController;
    private final Scanner sc;

    public EnrollmentView() {
        this.enrollmentController = new EnrollmentController();
        this.disciplineController = new DisciplineController();
        this.sc = new Scanner(System.in);

    }


    public void displayCourseMenu() {
        System.out.println("8. See all disciplines");
        System.out.println("9. Enroll a student in a discipline");
        System.out.println("10. List discipline enrolled by a student");
        System.out.println("11. Remove a discipline from enrollment");
        System.out.println("0. Exit");

    }




    public void showDiscipline() {
        disciplineController.showDisciplines();

    }

    public void enrollStudentInCourse() {
        disciplineController.showDisciplines();
        System.out.print("Enter the student ID: ");
        int studentId = sc.nextInt();
        System.out.print("Enter the discipline ID: ");
        int courseId = sc.nextInt();
        String response = enrollmentController.enrollStudent(studentId, courseId);
        System.out.println(response);

    }

    public void listStudentCourses() {
        System.out.print("Enter the student ID: ");
        int studentId = sc.nextInt();
        String response = enrollmentController.listEnrolledDisciplines(studentId);
        System.out.println(response);

    }

    public void removeCourseFromStudent() {
        System.out.print("Enter the student ID: ");
        int studentId = sc.nextInt();
        System.out.print("Enter the discipline ID: ");
        int courseId = sc.nextInt();
        String response = enrollmentController.removeEnrolledDiscipline(studentId, courseId);
        System.out.println(response);

    }
}

