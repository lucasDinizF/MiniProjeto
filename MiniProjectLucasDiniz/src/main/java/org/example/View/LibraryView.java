package org.example.View;

import org.example.Controller.LibraryController;

import java.util.Scanner;

public class LibraryView {
    private final LibraryController libraryController;
    private final Scanner sc;

    public LibraryView() {
        this.libraryController = new LibraryController();
        this.sc = new Scanner(System.in);
    }

    public void displayBookMenu() {
        System.out.println("4. See all books");
        System.out.println("5. Reserve a book");
        System.out.println("6. List books reserved by a student");
        System.out.println("7. Cancel a book reservation");

    }

    public void reserveBook() {
        libraryController.showBooks();
        System.out.print("Enter the student's ID: ");
        int studentId = sc.nextInt();
        System.out.print("Enter the book's ID: ");
        int bookId = sc.nextInt();
        String response = libraryController.reserveBook(studentId, bookId);
        System.out.println(response);
    }

    public void listReservedBooksByStudent() {
        System.out.print("Enter the student's ID: ");
        int studentId = sc.nextInt();
        String response = libraryController.listReservedBooks(studentId);
        System.out.println(response);
    }

    public void showBooks(){
        libraryController.showBooks();

    }

    public void cancelBookReservation() {
        System.out.print("Enter the student's ID: ");
        int studentId = sc.nextInt();
        System.out.print("Enter the book's ID: ");
        int bookId = sc.nextInt();
        String response = libraryController.cancelReservation(studentId, bookId);
        System.out.println(response);
    }
}

