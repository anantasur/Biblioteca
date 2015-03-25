package com.twu.biblioteca;

public class QuitCommand implements Command {
    @Override
    public void execute() throws QuitCommandException {
        throw new QuitCommandException("Thank you! visit again");
    }
}
