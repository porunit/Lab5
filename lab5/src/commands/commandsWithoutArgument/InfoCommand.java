package commands.commandsWithoutArgument;

import Interfaces.Command;
import Interfaces.CommandWithoutArgument;
import executionManager.CollectionManager;

import java.time.format.DateTimeFormatter;

public class InfoCommand implements CommandWithoutArgument, Command {

    public void execute() {
        System.out.println("type: " + CollectionManager.getCollectionType() + "\n" +
                "creation date: " + java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "\n" +
                "size: " + CollectionManager.getAmountElements() +
                "\n");
    }

    @Override
    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
