package executionManager;


import commandEnums.CommandsWithArgument;
import commandEnums.CommandsWithoutArgument;
import commandEnums.Mode;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CommandParser {
    private final CommandManager commandM;
    public CommandParser(CommandManager commandM){
        this.commandM = commandM;
    }
    public void parse(String command) {
        command = command.trim();
        String[] array = command.split("\\s+");
        var node = array[0];
       if(isCommand(node)){
            if (isCommandWithArgument(node)){
                if(array.length>2) System.out.println("Wrong argument format");
                else if(array.length!=2 || array[1] == null || array[1].equals(""))
                    System.out.println("Missed command argument");
                else {
                    switch (CommandsWithArgument.valueOf(node)) {
                        case add -> commandM.add(array[1]);
                        case update -> commandM.idContainsCommands(array[1], Mode.UPDATE);
                        case remove -> commandM.idContainsCommands(array[1], Mode.REMOVE);
                        case filter_by_semester_enum -> commandM.filterBySemesterEnum(array[1]);
                        case insert_at -> commandM.insertAt(array[1]);
                        case add_if_min -> commandM.addIfMin();
                        case execute_script -> executionScript(array[1]);
                    }
                }
            }
            else if(array.length == 1){
                switch (CommandsWithoutArgument.valueOf(node)) {
                    case print_field_descending_form_of_education -> commandM.printFieldDescendingFormOfEducation();
                    case show -> commandM.show();
                    case print_descending -> commandM.printDescending();
                    case save -> commandM.save();
                    case info -> commandM.info();
                    case help -> commandM.help();
                    case clear -> commandM.clear();
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
        if(isCommandWithoutArgument(command)|| isCommandWithArgument(command)) return true;
        return false;
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
