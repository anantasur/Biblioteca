package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class ReturnCommand implements Command{
    private Library library;
    private InputStream in;
    private PrintStream ps;

    public ReturnCommand(Library library, InputStream in, PrintStream ps) {
        this.library = library;
        this.in = in;
        this.ps = ps;
    }

    @Override
    public void execute() {
        ps.print("Enter the Book Name:" + System.lineSeparator());
        Scanner scanner = new Scanner(in);
        if(library.checkIn(scanner.next()))
            ps.print("Thank you for returning the book."+System.lineSeparator());
        else
            ps.print("This is not a valid book to return."+System.lineSeparator());
    }
}