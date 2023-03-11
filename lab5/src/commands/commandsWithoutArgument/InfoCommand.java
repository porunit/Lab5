package commands.commandsWithoutArgument;

import executionManager.CollectionManager;
import interfaces.CommandWithoutArgument;

import java.time.format.DateTimeFormatter;

public class InfoCommand implements CommandWithoutArgument {

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
