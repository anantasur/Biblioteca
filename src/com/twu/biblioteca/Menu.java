package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItemList;

    public Menu() {
        this.menuItemList = new ArrayList<MenuItem>();
    }

    public void add(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public String asString() {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for (MenuItem menuItem : menuItemList) {
            stringBuilder.append(++counter);
            stringBuilder.append(". ");
            stringBuilder.append(menuItem.asString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void optionHandler(int option) throws QuitCommandException {
        menuItemList.get(option - 1).performAction();
    }
}
