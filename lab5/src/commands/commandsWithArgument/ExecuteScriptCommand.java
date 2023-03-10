package commands.commandsWithArgument;

import interfaces.Command;
import interfaces.CommandWithArgument;

import executionManager.CommandParser;

public class ExecuteScriptCommand implements CommandWithArgument, Command {

    @Override
    public void execute(String argument) {
        new CommandParser().executionScript(argument);
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

}
