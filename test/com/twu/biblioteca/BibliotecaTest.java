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
}
