package commands.commandswithoutargument;

import executionmanager.CollectionManager;
import interfaces.CommandWithoutArgument;

public class ClearCommand implements CommandWithoutArgument {

    /**
     * Action for <b>clear</b> command.
     * Doesn't receive arguments
     */
    @Override
    public void execute() {
        CollectionManager.clear();
    }

    @Override
    public String getDescription() {
        return "clear : очистить коллекцию";
    }
}
