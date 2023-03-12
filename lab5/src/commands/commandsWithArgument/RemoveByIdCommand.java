package commands.commandswithargument;

import executionmanager.CollectionManager;
import interfaces.CommandWithArgument;

public class RemoveByIdCommand implements CommandWithArgument {

    /**
     * Action for <b>remove</b> command.
     * Receive arguments
     *
     * @param argument command parameter
     */
    public void execute(String argument) {
        long id = 0;
        try {
            id = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("id must be number");
        } finally {
            if (CollectionManager.isStackEmpty()) System.out.println("Collection is empty");
            else if (!CollectionManager.checkId(id)) System.out.println("id doesn't exists");
            else CollectionManager.remove(id);
        }
    }

    @Override
    public String getDescription() {
        return "remove id {element}: удалить значение элемента коллекции, id которого равен заданному";
    }
}
