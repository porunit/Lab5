package executionManager;


import commandEnums.CommandsWithArgument;
import commandEnums.CommandsWithoutArgument;
import commandEnums.Mode;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CommandParser {
    private final CommandManager commandManager;
    public CommandParser(CommandManager commandM){
        this.commandManager = commandM;
    }
    public void parse(String command) {
        command = command.trim();
        String[] array = command.split("\\s+");
        var node = array[0];
        int COMMAND_NO_ARG_LENGTH = 1;
       if(isCommand(node)){
            if (isCommandWithArgument(node)) {
                if(array.length>2) System.out.println("Wrong argument format");
                else if(array.length!=2 || array[1] == null || array[1].equals(""))
                    System.out.println("Missed command argument");
                else {
                    String argument = array[1];
                    switch (CommandsWithArgument.valueOf(node)) {
                        case add -> commandManager.add(argument);
                        case update -> commandManager.idContainsCommands(argument, Mode.UPDATE);
                        case remove -> commandManager.idContainsCommands(argument, Mode.REMOVE);
                        case filter_by_semester_enum -> commandManager.filterBySemesterEnum(argument);
                        case insert_at -> commandManager.insertAt(argument);
                        case add_if_min -> commandManager.addIfMin();
                        case execute_script -> executionScript(argument);
                    }
                }
            }
            else if(array.length == COMMAND_NO_ARG_LENGTH) {
                switch (CommandsWithoutArgument.valueOf(node)) {
                    case print_field_descending_form_of_education -> commandManager.printFieldDescendingFormOfEducation();
                    case show -> commandManager.show();
                    case print_descending -> commandManager.printDescending();
                    case save -> commandManager.save();
                    case info -> commandManager.info();
                    case help -> commandManager.help();
                    case clear -> commandManager.clear();
                }
            }
            else{
                System.out.println("This command doesn't contains argument");
            }
       }
       else System.out.println("Command doesn't exists");
    }



    private boolean isCommandWithArgument(@NotNull String command){
        try{
            CommandsWithArgument.valueOf(command);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private boolean isCommand(@NotNull String command) {
        return isCommandWithoutArgument(command) || isCommandWithArgument(command);
    }
    public void executionScript(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while(scanner.hasNextLine()){
                parse(String.valueOf(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (StackOverflowError e){
            System.out.println("Recursion script error");
        }
    }
    private boolean isCommandWithoutArgument(String command){
        try {
            CommandsWithoutArgument.valueOf(command);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
