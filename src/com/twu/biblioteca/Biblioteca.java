package com.twu.biblioteca;

import java.io.PrintStream;
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
        boolean KEEP_RUNNING = true;
        System.out.println(getWelcomeMessage());
        Scanner scanner = new Scanner(System.in);
        Menu menu = createMenu(new Library("./data/books"));
        while (KEEP_RUNNING){
            System.out.println(listAllOptions(menu));
            try {
                int option = scanner.nextInt();
                menu.optionHandler(option);
            } catch (QuitCommandException qe) {
                System.out.println(qe.getMessage());
                KEEP_RUNNING = false;
            }catch(InvalidOptionException ioe){
                System.out.println(ioe.getMessage());
            }catch(Exception e){
                System.out.println("OOPS!! Some unknown error occurred!!");
                KEEP_RUNNING = false;
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
        menu.add(new MenuItem("CheckOut Book",new CheckOutCommand(library, System.in, System.out)));
        menu.add(new MenuItem("Quit",new QuitCommand()));
        return menu;
    }
}
