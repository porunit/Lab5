package commands.commandsWithoutArgument;

import executionManager.CollectionManager;
import interfaces.CommandWithoutArgument;

public class ClearCommand implements CommandWithoutArgument {
    @Override
    public void execute() {
        CollectionManager.clear();
    }

    @Override
    public String getDescription() {
        return "clear : очистить коллекцию";
    }
}
