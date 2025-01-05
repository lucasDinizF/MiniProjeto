package org.example.microServices;


import org.example.Model.Book;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class BookParser implements JsonParser<Book> {

    @Override
    public List<Book> parse(String responseBody) {
        JSONArray booksArray = new JSONArray(responseBody);
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < booksArray.length(); i++) {
            JSONObject bookObj = booksArray.getJSONObject(i);
            Book book = new Book(
                    bookObj.getInt("id"),
                    bookObj.getString("titulo"),
                    bookObj.getString("autor"),
                    bookObj.getInt("ano"),
                    bookObj.getString("status")
            );
            books.add(book);
        }
        return books;
    }
}

