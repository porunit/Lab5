package commands.commandsWithArgument;

import interfaces.Command;
import interfaces.CommandWithArgument;
import commands.commandsWithoutArgument.AddCommand;
import executionManager.CollectionManager;

public class UpdateCommand implements CommandWithArgument, Command {

    @Override
    public void execute(String argument) {
        long id = 0;
        try {
            id = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("id must be number");
            return;
        }
        if (CollectionManager.isStackEmpty()) System.out.println("Collection is empty");
        else if (!CollectionManager.checkId(id)) System.out.println("id doesn't exists");
        else {
            var group = AddCommand.add();
            group.setId(id);
            CollectionManager.remove(id);
            CollectionManager.add(group);
        }
    }

    @Override
    public String getDescription() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}

