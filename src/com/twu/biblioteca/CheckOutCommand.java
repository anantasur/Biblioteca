package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CheckOutCommand implements Command {
    private Library library;
    private InputStream in;
    private PrintStream ps;

    public CheckOutCommand(Library library, InputStream in, PrintStream ps) {
        this.library = library;
        this.in = in;
        this.ps = ps;
    }

    @Override
    public void execute() throws QuitCommandException, InvalidOptionException {
        Scanner scanner = new Scanner(in);
        ps.println("Enter the Book Name:");
        if(library.checkOutBook(scanner.next()))
            ps.println("Thank you! Enjoy The Book.");
        else
            ps.println("This Book Is Not Available.");
    }
}
