package commands.commandsWithoutArgument;

import commands.CommandMapsBuilder;
import interfaces.CommandWithArgument;
import interfaces.CommandWithoutArgument;
import java.util.HashMap;

public class HelpCommand implements CommandWithoutArgument {

    private HashMap<String, CommandWithoutArgument> commandsWithoutArgumentHashMap;
    private HashMap<String, CommandWithArgument> commandsWithArgumentHashMap;

    public void execute() {
       commandsWithoutArgumentHashMap = CommandMapsBuilder.buildCommandWithoutArgumentMap();
       commandsWithArgumentHashMap = CommandMapsBuilder.buildCommandWithArgumentMap();
        for(var it : commandsWithArgumentHashMap.values())
            System.out.println(it.getDescription());
        for (var it: commandsWithoutArgumentHashMap.values())
            System.out.println(it.getDescription());
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам";
    }
}
