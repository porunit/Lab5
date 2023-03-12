package commands.commandswithoutargument;

import executionmanager.CollectionManager;
import interfaces.CommandWithoutArgument;

import java.time.format.DateTimeFormatter;

public class InfoCommand implements CommandWithoutArgument {

    /**
     * Action for <b>info</b> command.
     * Doesn't receive arguments
     */
    public void execute() {
        System.out.println("type: " + CollectionManager.getCollectionType() + "\n" +
                "creation date: " + CollectionManager.getCreationDate() + "\n" +
                "size: " + CollectionManager.getAmountElements() +
                "\n");
    }

    @Override
    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
