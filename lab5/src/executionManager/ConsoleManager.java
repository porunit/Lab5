package executionManager;

import commands.LoadCommand;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleManager {
    private final CommandParser parser = new CommandParser();
    private final Scanner scanner = new Scanner(System.in);
    public void start() {
        try{
        LoadCommand.execute();
        }catch (NoSuchFieldError e){
            System.out.println("Error While loading");}
        String command = "";
        while (true){
            System.out.print("Enter command(type help to see command list): ");
            try {
                command = scanner.nextLine().trim();
            } catch (NoSuchElementException e){
                break;
            }
            parser.parse(command);
        }
    }
}
