package commands.commandsWithoutArgument;

import Interfaces.Command;
import Interfaces.CommandWithoutArgument;
import comparators.StudyGroupComparator;
import executionManager.CollectionManager;

public class PrintDescendingCommand implements CommandWithoutArgument, Command {

    public void execute() {
        var groups = CollectionManager.getAll();
        groups.sort(new StudyGroupComparator());
        for (var it : groups) {
            System.out.println(it);
        }
    }

    @Override
    public String getDescription() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
