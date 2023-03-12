package commands.commandswithoutargument;

import executionmanager.CollectionManager;
import interfaces.CommandWithoutArgument;

public class PrintDescendingCommand implements CommandWithoutArgument {

    /**
     * Action for <b>print_descending</b> command.
     * Doesn't receive arguments
     */
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
