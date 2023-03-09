package commands.commandsWithoutArgument;

import Interfaces.Command;
import Interfaces.CommandWithoutArgument;

public class ExitCommand implements CommandWithoutArgument, Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
