package commands.commandsWithoutArgument;

import executionManager.CollectionManager;
import interfaces.CommandWithoutArgument;

public class PrintDescendingCommand implements CommandWithoutArgument {

    public void execute() {
        var groups = CollectionManager.getAll();
        for (var i = groups.size() - 1; i > 0; i--) {
            System.out.println(groups.get(i).toString());
        }
    }

    @Override
    public String getDescription() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
