package org.example.microServices;


import java.util.List;

public interface JsonParser<T> {

    List<T> parse(String responseBody);

}
