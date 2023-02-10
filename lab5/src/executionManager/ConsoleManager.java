package commandManager;

import commandManager.CollectionManager;
import commandManager.CommandParser;
import data.StudyGroup;

import java.util.Scanner;
import java.util.Stack;

public class ConsoleManager {
    private Stack<StudyGroup> studyGroups = new Stack<StudyGroup>();
    private CollectionManager collectionM = new CollectionManager(studyGroups);
    private CommandParser parser = new CommandParser(collectionM);
    private Scanner scaner = new Scanner(System.in);
    public void start(){
        while (true){
            System.out.print("Введите команду:");
            String command = scaner.nextLine().trim();
            if (command.equals("exit")) break;
            parser.parse(command);
            System.out.println();
        }
    }
}
