package com.twu.biblioteca;

public class MenuItem {
    private String menuName;
    private Command command;

    public MenuItem(String menuName, Command command) {
        this.menuName = menuName;
        this.command = command;
    }

    public String asString() {
        return menuName;
    }
    public void performAction() throws QuitCommandException, InvalidOptionException {
        command.execute();
    }
}
