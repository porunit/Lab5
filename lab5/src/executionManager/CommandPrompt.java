package executionmanager;

import commands.commandswithoutargument.LoadCommand;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandPrompt {
    private final CommandProcessor parser = new CommandProcessor();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method starts the console-based user interface for interacting with the study group collection.
     * It first tries to load the collection from the file using LoadCommand.
     * Then it enters a loop where it prompts the user for commands until the collection is loaded and the user
     * can enter commands. The method reads user input and passes it to the parse method of the Parser object for processing.
     * If an error occurs while loading or reading user input, an error message is printed and the method exits.
     */
    public void start() {
        boolean isLoaded;
        try {
            new LoadCommand().execute();
        } catch (NoSuchFieldError e) {
            System.out.println("Error While loading");
        } finally {
            isLoaded = !CollectionManager.isStackEmpty();
        }
        String command;
        while (isLoaded) {
            System.out.print("Enter command(type help to see command list): ");
            try {
                command = scanner.nextLine().trim();
            } catch (NoSuchElementException e) {
                break;
            }
            parser.parse(command);
        }
    }
}
