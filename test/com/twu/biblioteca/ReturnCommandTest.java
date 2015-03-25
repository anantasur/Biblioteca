package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReturnCommandTest {
    List<Book> bookList = new ArrayList<Book>();
    Library library ;

    @Before
    public void setUp() throws Exception {
        this.library = new Library("./data/testDB");
    }
    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsSuccessfullyReturned() throws Exception {
        library.checkOutBook("Ramayana");
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(library,in,ps).execute();
        assertEquals("Enter the Book Name:"+System.lineSeparator()+"Thank you for returning the book."+System.lineSeparator(),os.toString());
    }

    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsUnSuccessfullyReturned() throws Exception {
        InputStream in = new ByteArrayInputStream("Wings of Fire".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(library,in,ps).execute();
        assertEquals("Enter the Book Name:"+System.lineSeparator()+"This is not a valid book to return."+System.lineSeparator(),os.toString());
    }
}