package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckOutCommandTest {
    Library library ;

    @Before
    public void setUp() throws Exception {
        this.library = new Library("./data/testDB");
    }
    @Test
    public void testCheckOutShouldGiveSuccessMessageOnSuccessFulCheckOut() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        CheckOutCommand checkOutCommand = new CheckOutCommand(library,in,ps);
        checkOutCommand.execute();
        assertEquals("Enter the Book Name:"+System.lineSeparator()+"Thank you! Enjoy The Book."+ System.lineSeparator(),os.toString());
    }
    @Test
    public void testCheckOutShouldGiveMessageOnUnSuccessFullCheckout() throws Exception {
        InputStream in = new ByteArrayInputStream("Great Osama".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        new CheckOutCommand(library,in,ps).execute();
        assertEquals("Enter the Book Name:"+System.lineSeparator()+"This Book Is Not Available."+System.lineSeparator(),os.toString());
    }
}