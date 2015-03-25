package com.twu.biblioteca;

public class Biblioteca {
    public String getWelcomeMessage() {
        StringBuilder sb  = new StringBuilder();
        sb.append("*************************");
        sb.append(System.lineSeparator());
        sb.append("**Welcome To Biblioteca**");
        sb.append(System.lineSeparator());
        sb.append("*************************");
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public void run() {
        System.out.println(getWelcomeMessage());
        System.out.println(listAllBooks(new Library("./data/books")));
    }

    public String listAllBooks(Library library) {
        StringBuilder sb = new StringBuilder();
        sb.append("--------List Of Books--------");
        sb.append(System.lineSeparator());
        sb.append("Title - Author - Year - ISBN");
        sb.append(System.lineSeparator());
        sb.append("_____________________________");
        sb.append(System.lineSeparator());
        sb.append(library.asString());
        return sb.toString();
    }
}
