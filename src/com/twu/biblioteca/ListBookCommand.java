package com.twu.biblioteca;

public class ListBookCommand implements Command {
    private String bookList;

    public ListBookCommand(String bookList) {
        this.bookList = bookList;
    }

    @Override
    public void execute() {
        System.out.println(bookList);
    }
}
