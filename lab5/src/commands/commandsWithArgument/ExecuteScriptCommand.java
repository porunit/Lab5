package commands.commandswithargument;

import executionmanager.CommandProcessor;
import interfaces.CommandWithArgument;

public class ExecuteScriptCommand implements CommandWithArgument {

    @Override
    public void execute(String argument) {
        new CommandProcessor().executionScript(argument);
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

}
