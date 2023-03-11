package commands.commandswithoutargument;

import interfaces.CommandWithoutArgument;

public class ExitCommand implements CommandWithoutArgument {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
