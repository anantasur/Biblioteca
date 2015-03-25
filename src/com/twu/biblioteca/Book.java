package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private String isbn;

    public Book(String title, String author, String year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public String asString() {
        return title + " - " + author + " - " + year + " - " + isbn;
    }

    public boolean isName(String bookName) {
        return bookName.equals(title);
    }
}
