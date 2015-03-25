package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBookList;
    private List<Book> issuedBookList;

    public Library(String fileName) {
        this.availableBookList = createList(new FileScanner(fileName).read());
        this.issuedBookList = new ArrayList<Book>();
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
        for (Book book : availableBookList) {
            stringBuilder.append(book.asString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private Book searchBook(String bookName,List<Book> list){
        for (Book book : list) {
            if(book.isName(bookName))
                return book;
        }
        return null;
    }

    public boolean checkOutBook(String bookName) {
        Book b = searchBook(bookName, availableBookList);
        issuedBookList.add(b);
        return availableBookList.remove(b);
    }

    public boolean checkIn(String bookName) {
        Book b = searchBook(bookName,issuedBookList);
        if(b!=null) {
            availableBookList.add(b);
            return issuedBookList.remove(b);
        }
        return false;
    }
}
