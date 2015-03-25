package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAsStringGetsTheBookNamesPresentInDBInStringFormat(){
        Library library = new Library("./data/testDB");
        String books = library.asString();
        String expected = "Ramayana - Valmiki - 2004 - 420420"+System.lineSeparator();
        assertEquals(expected,books);
    }
    @Test
    public void testAsStringGetsAllTheBooksInStringFormat(){
        Library library = new Library("./data/books");
        StringBuilder expected = new StringBuilder();
        expected.append("Ramayana - Valmiki - 2004 - 420420");
        expected.append(System.lineSeparator());
        expected.append("The Adventures Of Sherlock Holmes - Sir Arthur Conan Doyle - 1998 - 123321");
        expected.append(System.lineSeparator());
        expected.append("Mahabharata - Vyas - 700 - 675645");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(),library.asString());
    }
}