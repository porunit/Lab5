package executionManager;

import data.StudyGroup;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleManager {
    private Stack<StudyGroup> studyGroups = new Stack<StudyGroup>();
    private CollectionManager collectionM = new CollectionManager(studyGroups);
    private CommandManager commandM = new CommandManager(collectionM);
    private CommandParser parser = new CommandParser(commandM);
    private Scanner scaner = new Scanner(System.in);
    public void start() throws IOException {
        while (true){
            System.out.print("Enter command: ");
            String command = scaner.nextLine().trim();
            if (command.equals("exit")) break;
            parser.parse(command);
            System.out.println();
        }
    }
}
