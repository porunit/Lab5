package executionManager;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;

class CommandParser {
    CommandManager commandM;
    String[] commandsWithArgument = new String[]{"add","update", "removeById", "filter_by_semester_enum","insert_at"};
    String[] commandsWithoutArgument = new String[]{"show", "print_field_descending_form_of_education", "print_descending","load","save","info","help"};

    public CommandParser(CommandManager commandM){
        this.commandM = commandM;
    }
    public void parse(String command) throws IOException {
        command = command.trim();
        String[] array = command.split("\\s+");
        var node = array[0];
       if(isCommand(node)){
            if (isCommandWithArgument(node)){
                if(array.length>2) System.out.println("Wrong argument format");
                else if(array.length!=2 || array[1] == null || array[1] == "")
                    System.out.println("Missed command argument");
                else if (node.equals("add")) commandM.add(array[1]);
                else if (node.equals("update")) commandM.idContainsComands(array[1], "update");
                else if (node.equals("removeById")) commandM.idContainsComands(array[1],"remove");
                else if (node.equals("filter_by_semester_enum")) commandM.filterBySemesterEnum(array[1]);
                else if (node.equals("insert_at")) commandM.insertAt(array[1]);
            }

            else if (node.equals("print_field_descending_form_of_education")) commandM.printFieldDescendingFormOfEducation();
            else if (node.equals("show")) commandM.show();
            else if (node.equals("print_descent")) commandM.printDescending();
            else if (node.equals("load")) commandM.load();
            else if (node.equals("save")) commandM.save();
            else if (node.equals("info")) commandM.info();
            else if (node.equals("help")) commandM.help();
       }
       else System.out.println("Command doesn't exists");
    }



    private boolean isCommandWithArgument(@NotNull String command){
        if(Arrays.asList(commandsWithArgument).contains(command)){
            return true;
        }
        return  false;
    }
    private boolean isCommand(@NotNull String command){
        if(Arrays.asList(commandsWithoutArgument).contains(command) || Arrays.asList(commandsWithArgument).contains(command)){
            return true;
        }
        return  false;
    }



}
