package org.example.View;

import org.example.microServices.BookService;
import org.example.microServices.DisciplineService;
import org.example.microServices.StudentService;

import java.util.Scanner;

public class MainView {
    private final StudentView studentView;
    private final EnrollmentView enrollmentView;
    private final LibraryView libraryView;
    private final Scanner sc;


    public MainView() {
        this.studentView = new StudentView();
        this.enrollmentView = new EnrollmentView();
        this.libraryView = new LibraryView();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        final DisciplineService disciplineService = new DisciplineService();
        disciplineService.getRefreshDisciplines();
        final BookService bookService = new BookService();
        bookService.getRefreshBooks();
        final StudentService studentService = new StudentService();
        studentService.getRefreshStudents();

        while (true) {
            displayMainMenu();
            int option = getUserOption();
            if (!processMainOption(option)) {
                break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("------- MAIN MENU -------");
        studentView.displayStudentMenu();
        libraryView.displayBookMenu();
        enrollmentView.displayCourseMenu();
    }

    private int getUserOption() {
        System.out.print("Choose an option: ");
        return sc.nextInt();
    }

    private boolean processMainOption(int option) {
        switch (option) {
            case 1 -> studentView.listHistoryInPersonStudents();
            case 2 -> studentView.viewStudentDetailsById();
            case 3 -> studentView.viewStudentDetailsByName();
            case 4 -> libraryView.showBooks();
            case 5 -> libraryView.reserveBook();
            case 6 -> libraryView.listReservedBooksByStudent();
            case 7 -> libraryView.cancelBookReservation();
            case 8 -> enrollmentView.showDiscipline();
            case 9 -> enrollmentView.enrollStudentInCourse();
            case 10 -> enrollmentView.listStudentCourses();
            case 11 -> enrollmentView.removeCourseFromStudent();
            case 0 -> {
                System.out.println("Exiting...");
                return false;
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
        return true;
    }
}
