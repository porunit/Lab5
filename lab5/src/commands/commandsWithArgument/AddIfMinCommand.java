package commands.commandsWithArgument;

import Interfaces.Command;
import Interfaces.CommandWithArgument;

public class AddIfMinCommand implements CommandWithArgument, Command {

    @Override
    public void execute(String argument) {
    }

    @Override
    public String getDescription() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
