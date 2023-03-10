package commands.commandsWithoutArgument;

import interfaces.Command;
import interfaces.CommandWithoutArgument;
import executionManager.CollectionManager;

public class ShowCommand implements CommandWithoutArgument, Command {

    public void execute() {
        for (var group : CollectionManager.getAll()) {
            System.out.println(group.toString());
        }
    }

    @Override
    public String getDescription() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
