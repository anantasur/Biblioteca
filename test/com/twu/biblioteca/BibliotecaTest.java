package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    @Test
    public void testGetWelcomeMessageGetsTheWelocomeMessage(){
        Biblioteca biblioteca  = new Biblioteca();
        StringBuilder expected  = new StringBuilder();
        expected.append("*************************");
        expected.append(System.lineSeparator());
        expected.append("**Welcome To Biblioteca**");
        expected.append(System.lineSeparator());
        expected.append("*************************");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString() , biblioteca.getWelcomeMessage());
    }

    @Test
    public void testListAllBooksShouldListAllTheBooks(){
        Library library = new Library("./data/testDB");
        Biblioteca biblioteca = new Biblioteca();
        StringBuilder expected = new StringBuilder();
        expected.append("--------List Of Books--------");
        expected.append(System.lineSeparator());
        expected.append("Title - Author - Year - ISBN");
        expected.append(System.lineSeparator());
        expected.append("_____________________________");
        expected.append(System.lineSeparator());
        expected.append("Ramayana - Valmiki - 2004 - 420420");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), biblioteca.listAllBooks(library));
    }
//    @Test
//    public void test(){
//        ;
//    }
}
