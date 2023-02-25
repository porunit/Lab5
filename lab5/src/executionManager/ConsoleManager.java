package executionManager;

import data.StudyGroup;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleManager {
    private final Stack<StudyGroup> studyGroups = new Stack<>();
    private final CollectionManager collectionM = new CollectionManager(studyGroups);
    private final CommandManager commandM = new CommandManager(collectionM);
    private final CommandParser parser = new CommandParser(commandM);
    private final Scanner scanner = new Scanner(System.in);
    public void start() {
        try{
        commandM.load();
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
            if (command.equals("exit")) break;
            parser.execute(parser.parse(command));
            System.out.println();
        }
    }
}
