package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String fileName;
    List<Book> bookList;

    public Library(String fileName) {
        this.fileName = fileName;
        this.bookList = createList(new FileScanner(fileName).read());
    }
    private List<Book> createList(String books){
        List<Book> listOfBooks = new ArrayList<Book>();
        for (String book : books.split(System.lineSeparator())) {
            String[] bookDetails = splitByComma(book);
            listOfBooks.add(new Book(bookDetails[0],bookDetails[1],bookDetails[2],bookDetails[3]));
        }
        return listOfBooks;
    }

    private String[] splitByComma(String line) {
        String[] words = line.split(",");
        String[] updatedWords = new String[words.length];
        for (int count = 0; count < words.length; count++) {
            updatedWords[count] = words[count].trim();
        }
        return updatedWords;
    }

    public String asString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : bookList) {
            stringBuilder.append(book.asString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
