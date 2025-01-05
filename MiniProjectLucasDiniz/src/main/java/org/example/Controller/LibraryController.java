package org.example.Controller;

import org.example.Model.Student;
import org.example.Model.Book;
import org.example.microServices.BookService;
import org.example.microServices.LibraryService;
import org.example.microServices.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryController {
    private final BookService bookService;
    private final LibraryService libraryService;
    private final StudentService studentService;

    public LibraryController() {
        this.bookService = new BookService();
        this.libraryService = new LibraryService();
        this.studentService = new StudentService();
    }


    public String reserveBook(int studentId, int bookId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null && "ativo".equalsIgnoreCase(student.getStatus())) {
            Book selectedBook = bookService.findBookById(bookId);

            if (selectedBook != null) {
                boolean success = libraryService.reserveBook(student, selectedBook);
                if (success) {
                    return "Reservation successful.\n";
                } else {
                    return "The book is already reserved.\n";
                }
            } else {
                return "Book not found.\n";
            }
        } else {
            return "Student not found or not active.\n";
        }
    }

    public String listReservedBooks(int studentId) {
        List<Book> books = libraryService.listReservedBooks(studentId);
        return books.isEmpty()
                ? "No books reserved for this student.\n"
                : books.stream().map(Book::toString).collect(Collectors.joining("\n"));

    }



    public String cancelReservation(int studentId, int bookId) {
        Book selectedBook = bookService.findBookById(bookId);

        if (selectedBook != null && selectedBook.isReserved()) {
            if (libraryService.cancelReservation(studentId, bookId)) {
                selectedBook.setReserved(false); // Mark the book as available
                return "Reservation successfully canceled.\n";
            } else {
                return "Error canceling the reservation.\n";
            }
        } else {
            return "Book is not reserved or not found.\n";
        }
    }


    public void showBooks() {
        List<Book> availableBooks = bookService.listBooks();
        System.out.println("\nBooks available for reservation:");
        availableBooks.forEach(System.out::println);
    }
}
