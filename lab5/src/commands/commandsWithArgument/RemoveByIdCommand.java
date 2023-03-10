package commands.commandsWithArgument;

import interfaces.Command;
import interfaces.CommandWithArgument;
import executionManager.CollectionManager;

public class RemoveByIdCommand implements CommandWithArgument, Command {

    public void execute(String argument){
        long id = 0;
        try {
            id = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("id must be number");
        }
        finally {
            if (CollectionManager.checkId(id)) System.out.println("Collection is empty");
            else if (!CollectionManager.checkId(id)) System.out.println("id doesn't exists");
            else CollectionManager.remove(id);
        }
    }

    @Override
    public String getDescription() {
        return "remove id {element}: удалить значение элемента коллекции, id которого равен заданному";
    }
}
