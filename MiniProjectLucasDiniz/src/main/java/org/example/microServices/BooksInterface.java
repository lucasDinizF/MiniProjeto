package org.example.microServices;

import org.example.Model.Book;

import java.util.List;

public interface BooksInterface {
    void getRefreshBooks();
    List<Book> listBooks();

}
