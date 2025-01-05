package org.example.microServices;

import org.example.Model.Book;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService implements BooksInterface {
    private final Map<Integer, Book> booksMap = new HashMap<>();
    private final String endpoint = "https://qiiw8bgxka.execute-api.us-east-2.amazonaws.com/acervo/biblioteca";
    private final HttpClient client = HttpClient.newHttpClient();
    private final BookParser parser = new BookParser();

    private boolean cacheInitialized = false;

    public BookService() {
        getRefreshBooks();
    }


    public void getRefreshBooks() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Book> books = parser.parse(response.body());

            booksMap.clear();
            for (Book book : books) {
                booksMap.put(book.getId(), book);
            }
            cacheInitialized = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public List<Book> listBooks() {
        if (!cacheInitialized) {
            getRefreshBooks();
        }
        return new ArrayList<>(booksMap.values());
    }


    public Book findBookById(int bookId) {
        if (!cacheInitialized) {
            getRefreshBooks();
        }
        return booksMap.get(bookId);
    }
}
