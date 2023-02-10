package executionManager;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

class CommandParser {
    CommandManager commandM;
    String[] commandsWithArgument = new String[]{"add","update", "removeById"};
    String[] commandsWithoutArgument = new String[]{"show"};

    public CommandParser(CommandManager commandM){
        this.commandM = commandM;
    }
    public void parse(String command) {
        command = command.trim();
        String[] array = command.split("\\s+");
       if(isCommand(array[0])){
            if (isCommandWithArgument(array[0])){
                if(array.length>2) System.out.println("Wrong argument");
                else if(array.length!=2 || array[1]==null || array[1] == ""){
                    System.out.println("Missed command argument");
                }
                else if (array[0].equals("add")) {
                    commandM.add(array[1]);
                } else if(array[0].equals("update")) {
                    commandM.idContainsComands(array[1], "update");
                } else if (array[0].equals("removeById")) {
                    commandM.idContainsComands(array[1],"remove");
                }
            }

           else if (array[0].equals("show")) {
               commandM.show();
           }
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
