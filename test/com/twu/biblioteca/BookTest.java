package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testAsStringGivesTheDetailsOfBookInStringFormat(){
        Book book = new Book("Ramayana","Valmiki","1999","234567");
        String expected = "Ramayana - Valmiki - 1999 - 234567";
        assertEquals(expected, book.asString());
    }
}