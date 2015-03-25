package com.twu.biblioteca;

public class Biblioteca {
    public String getWelcomeMessage() {
        StringBuilder sb  = new StringBuilder();
        sb.append("*************************");
        sb.append(System.lineSeparator());
        sb.append("**Welcome To Biblioteca**");
        sb.append(System.lineSeparator());
        sb.append("*************************");
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public void run() {
        System.out.println(getWelcomeMessage());
    }
}
