package commands;

import commands.commandswithargument.*;
import commands.commandswithoutargument.*;
import interfaces.CommandWithArgument;
import interfaces.CommandWithoutArgument;

import java.util.HashMap;

public class CommandMapsBuilder {

    public static HashMap buildCommandWithArgumentMap() {
        HashMap<String, CommandWithArgument> commandWithArgumentMap = new HashMap<>();
        commandWithArgumentMap.put("add_if_min", new AddIfMinCommand());
        commandWithArgumentMap.put("filter_by_semester", new FilterBySemesterEnumCommand());
        commandWithArgumentMap.put("insert_at", new InsertAtCommand());
        commandWithArgumentMap.put("remove", new RemoveByIdCommand());
        commandWithArgumentMap.put("update", new UpdateCommand());
        commandWithArgumentMap.put("execute_script", new ExecuteScriptCommand());
        return commandWithArgumentMap;
    }

    public static HashMap buildCommandWithoutArgumentMap() {
        HashMap<String, CommandWithoutArgument> commandWithoutArgumentMap = new HashMap<>();
        commandWithoutArgumentMap.put("exit", new ExitCommand());
        commandWithoutArgumentMap.put("clear", new ClearCommand());
        commandWithoutArgumentMap.put("add", new AddCommand());
        commandWithoutArgumentMap.put("help", new HelpCommand());
        commandWithoutArgumentMap.put("info", new InfoCommand());
        commandWithoutArgumentMap.put("load", new LoadCommand());
        commandWithoutArgumentMap.put("print_descending", new PrintDescendingCommand());
        commandWithoutArgumentMap.put("print_field_descending_form_of_education", new PrintFieldDescendingFormOfEducationCommand());
        commandWithoutArgumentMap.put("save", new SaveCommand());
        commandWithoutArgumentMap.put("show", new ShowCommand());
        return commandWithoutArgumentMap;
    }
}
