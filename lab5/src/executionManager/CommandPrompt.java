package executionmanager;

import commands.commandswithoutargument.LoadCommand;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandPrompt {
    private final CommandProcessor parser = new CommandProcessor();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        var isLoaded = true;
        try {
            new LoadCommand().execute();
        } catch (NoSuchFieldError e) {
            System.out.println("Error While loading");
            isLoaded = false;
        }
        String command = "";
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
