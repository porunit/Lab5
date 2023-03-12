
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

    /**
     * Parses the command input string and executes the corresponding command. The method first trims the input string and
     * splits it into an array of strings separated by whitespace. The first element of the array is checked if it is a
     * valid command. If not, an error message is printed. If it is a command without argument, and the array length is not
     * equal to the expected length, another error message is printed. If it is a command without argument and the length is
     * correct, the corresponding command is executed. If it is a command with argument, the array length is checked, and if
     * it is not equal to 2 or the second argument is null or empty, an error message is printed. Otherwise, the second
     * element of the array is retrieved as the argument and the corresponding command is executed with that argument.
     *
     * @param commandName a string representing the command input to parse
     */
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

    /**
     * Reads liens from script.txt file with commands and parse them one by one with  parse() method. If path is incorrect,
     * error message is printed. If is recursion in script, then if it loops, another error message is printed.
     *
     * @param path file name or location
     */
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
