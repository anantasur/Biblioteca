package com.twu.biblioteca;

import jdk.internal.util.xml.impl.Input;
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

    @Test
    public void testListAllOptionsShouldListAllTheOptions(){
        Biblioteca biblioteca = new Biblioteca();
        Menu menu  = new Menu();
        Library library = new Library("./data/testDB");
        menu.add(new MenuItem("List Books",new ListBookCommand(biblioteca.listAllBooks(library))));
        menu.add(new MenuItem("Quit",new QuitCommand()));
        StringBuilder expected = new StringBuilder();
        expected.append("1. List Books");
        expected.append(System.lineSeparator());
        expected.append("2. Quit");
        expected.append(System.lineSeparator());
        assertEquals(expected.toString(), biblioteca.listAllOptions(menu));
    }
//    @Test
//    public void testListAllOptionsShouldListAllTheOptionsIncludingCheckoutOption(){
//        Biblioteca biblioteca = new Biblioteca();
//        Menu menu  = new Menu();
//        Library library = new Library("./data/testDB");
//        menu.add(new MenuItem("List Books",new ListBookCommand(biblioteca.listAllBooks(library))));
//        menu.add(new MenuItem("CheckOut Book",new CheckOutCommand(library, Input.in, ps)));
//        menu.add(new MenuItem("Quit",new QuitCommand()));
//        StringBuilder expected = new StringBuilder();
//        expected.append("1. List Books");
//        expected.append(System.lineSeparator());
//        expected.append("2. CheckOut Book");
//        expected.append(System.lineSeparator());
//        expected.append("3. Quit");
//        expected.append(System.lineSeparator());
//        assertEquals(expected.toString(), biblioteca.listAllOptions(menu));
//    }
}
