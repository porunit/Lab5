package commands.commandswithoutargument;

import interfaces.CommandWithArgument;
import interfaces.CommandWithoutArgument;

import java.util.HashMap;

import static commands.CommandMapsBuilder.*;

public class HelpCommand implements CommandWithoutArgument {

    private HashMap<String, CommandWithoutArgument> commandsWithoutArgumentHashMap;
    private HashMap<String, CommandWithArgument> commandsWithArgumentHashMap;

    /**
     * Action for <b>help</b> command.
     * Doesn't receive arguments
     */
    public void execute() {
        commandsWithoutArgumentHashMap = buildCommandWithoutArgumentMap();
        commandsWithArgumentHashMap = buildCommandWithArgumentMap();
        for (var it : commandsWithArgumentHashMap.values())
            System.out.println(it.getDescription());
        for (var it : commandsWithoutArgumentHashMap.values())
            System.out.println(it.getDescription());
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }
}
