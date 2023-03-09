package commands;

import Interfaces.CommandWithArgument;
import Interfaces.CommandWithoutArgument;
import commands.commandsWithArgument.*;
import commands.commandsWithoutArgument.*;

import java.util.HashMap;

public class CommandMapsBuilder {

    public static HashMap buildCommandWithArgumentMap() {
        HashMap<String, CommandWithArgument> commandWithArgumentMap = new HashMap<>();
        commandWithArgumentMap.put("add_if_min", (String argument) -> new AddIfMinCommand().execute(argument));
        commandWithArgumentMap.put("filter_by_semester", (String argument) -> new FilterBySemesterEnumCommand().execute(argument));
        commandWithArgumentMap.put("insert_at", (String argument) -> new InsertAtCommand().execute(argument));
        commandWithArgumentMap.put("remove", (String argument) -> new RemoveByIdCommand().execute(argument));
        commandWithArgumentMap.put("update", (String argument) -> new UpdateCommand().execute(argument));
        commandWithArgumentMap.put("execute_script", (String argument) -> new ExecuteScriptCommand().execute(argument));
        return commandWithArgumentMap;
    }

    public static HashMap buildCommandWithoutArgumentMap() {
        HashMap<String, CommandWithoutArgument> commandWithoutArgumentMap = new HashMap<>();
        commandWithoutArgumentMap.put("exit", () -> new ExitCommand().execute());
        commandWithoutArgumentMap.put("clear", () -> new ClearCommand().execute());
        commandWithoutArgumentMap.put("add", () -> new AddCommand().execute());
        commandWithoutArgumentMap.put("help", () -> new HelpCommand().execute());
        commandWithoutArgumentMap.put("info", () -> new InfoCommand().execute());
        commandWithoutArgumentMap.put("load", () -> new LoadCommand().execute());
        commandWithoutArgumentMap.put("print_descending", () -> new PrintDescendingCommand().execute());
        commandWithoutArgumentMap.put("print_field_descending_form_of_education", () -> new PrintFieldDescendingFormOfEducationCommand().execute());
        commandWithoutArgumentMap.put("save", () -> new SaveCommand().execute());
        commandWithoutArgumentMap.put("show", () -> new ShowCommand().execute());
        return commandWithoutArgumentMap;
    }
}
