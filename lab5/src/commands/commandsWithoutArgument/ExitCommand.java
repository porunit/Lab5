package commands.commandswithoutargument;

import interfaces.CommandWithoutArgument;

public class ExitCommand implements CommandWithoutArgument {

    /**
     * Action for <b>exit</b> command.
     * Doesn't receive arguments
     */
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
