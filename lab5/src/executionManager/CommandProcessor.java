package executionmanager;


import commands.CommandMapsBuilder;
import interfaces.CommandWithArgument;
import interfaces.CommandWithoutArgument;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessor {
    final int COMMAND_NO_ARG_LENGTH = 1;
    private final HashMap<String, CommandWithoutArgument> commandsWithoutArgumentHashMap = CommandMapsBuilder.buildCommandWithoutArgumentMap();
    private final HashMap<String, CommandWithArgument> commandsWithArgumentHashMap = CommandMapsBuilder.buildCommandWithArgumentMap();

    public CommandProcessor() {

    }

    public void parse(String commandName) {
        commandName = commandName.trim();
        String[] array = commandName.split("\\s+");
        var node = array[0];
        if (!isCommand(node)) {
            System.out.println("Command doesn't exists");
        } else if (isCommandWithoutArgument(node) && array.length != COMMAND_NO_ARG_LENGTH) {
            System.out.println("This command doesn't contains argument");
        } else if (isCommandWithoutArgument(node) && array.length == COMMAND_NO_ARG_LENGTH) {
            CommandWithoutArgument command = commandsWithoutArgumentHashMap.get(commandName);
            command.execute();
        } else if (array.length != 2 || array[1] == null || array[1].equals("")) {
            System.out.println("Wrong argument format");
        } else {
            String argument = array[1];
            CommandWithArgument command = commandsWithArgumentHashMap.get(node);
            command.execute(argument);
        }
    }

    private boolean isCommandWithArgument(@NotNull String command) {
        return commandsWithArgumentHashMap.containsKey(command);
    }

    private boolean isCommand(@NotNull String command) {
        return isCommandWithoutArgument(command) || isCommandWithArgument(command);
    }

    public void executionScript(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                parse(String.valueOf(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (StackOverflowError e) {
            System.out.println("Recursion script error");
        }
    }

    private boolean isCommandWithoutArgument(String command) {
        return commandsWithoutArgumentHashMap.containsKey(command);
    }
}
