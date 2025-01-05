package org.example.Model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String reserved;

    public Book(int id, String title, String author, int year, String reserved) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getReserved() {
        return reserved;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isReserved() {
        return "reserved".equalsIgnoreCase(reserved);
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved ? "reserved" : "available";

    }



    public String toString() {
        return "id: " + getId() + "\n" + "Title: " +  getTitle() + "\n" + "Author: " +  getAuthor() + "\n" + "Year: " +  getYear() + "\n" + "Status: " +  getReserved() + "\n";
    }
}
