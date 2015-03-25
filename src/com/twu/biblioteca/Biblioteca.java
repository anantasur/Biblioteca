package com.twu.biblioteca;

import java.util.Scanner;

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
        final boolean KEEP_RUNNING = true;
        System.out.println(getWelcomeMessage());
        Scanner scanner = new Scanner(System.in);
        Menu menu = createMenu(new Library("./data/books"));
        while (KEEP_RUNNING){
            System.out.println(listAllOptions(menu));
            int option = scanner.nextInt();
            try {
                menu.optionHandler(option);
            } catch (QuitCommandException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    public String listAllBooks(Library library) {
        StringBuilder sb = new StringBuilder();
        sb.append("--------List Of Books--------");
        sb.append(System.lineSeparator());
        sb.append("Title - Author - Year - ISBN");
        sb.append(System.lineSeparator());
        sb.append("_____________________________");
        sb.append(System.lineSeparator());
        sb.append(library.asString());
        return sb.toString();
    }

    public String listAllOptions(Menu menu) {
        return menu.asString();
    }

    public Menu createMenu(Library library){
        Menu menu = new Menu();
        menu.add(new MenuItem("List Books",new ListBookCommand(listAllBooks(library))));
        menu.add(new MenuItem("Quit",new QuitCommand()));
        return menu;
    }
}
