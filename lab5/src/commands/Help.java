package commands;

import commandEnums.Mode;
import executionManager.CommandDescriptionManager;

public class Help {

    public static void help() {
        CommandDescriptionManager commandsDescription = new CommandDescriptionManager();
        commandsDescription.help();
        commandsDescription.idContainsCommands("", Mode.REMOVE);
        commandsDescription.idContainsCommands("", Mode.UPDATE);
        commandsDescription.add("");
        commandsDescription.clear();
        commandsDescription.info();
        commandsDescription.addIfMin();
        commandsDescription.filterBySemesterEnum("");
        commandsDescription.insertAt("");
        commandsDescription.printDescending();
        commandsDescription.printFieldDescendingFormOfEducation();
        commandsDescription.save();
    }
}
