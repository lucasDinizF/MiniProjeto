package org.example.microServices;

import org.example.Model.Student;
import org.example.Model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private final Map<Integer, List<Book>> reservations;

    public LibraryService() {
        this.reservations = new HashMap<>();

    }

    public boolean reserveBook(Student student, Book book) {
        if (book.isReserved()) {
            return false;
        }
        if (student != null && "ativo".equalsIgnoreCase(student.getStatus())) {
            if (!reservations.containsKey(student.getId())) {
                reservations.put(student.getId(), new ArrayList<>());
            }

            reservations.get(student.getId()).add(book);
            book.setReserved(true);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> listReservedBooks(int studentId) {
        return reservations.getOrDefault(studentId, new ArrayList<>());
    }

    public boolean cancelReservation(int studentId, int bookId) {
        List<Book> reservedBooks = reservations.get(studentId);
        if (reservedBooks != null) {
            return reservedBooks.removeIf(book -> book.getId() == bookId);
        }
        return false;
    }
}