package commands;

import executionManager.CollectionManager;

import java.time.format.DateTimeFormatter;

public class InfoCommand {

    public static void execute(){
        System.out.println("type: Stack\n" +
                "creation date: "+ java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"\n" +
                "size: "+ CollectionManager.getAmountElements() +
                "\n");
    }
}
