package commandManager;


import exceptions.InvalidCommandArgumentException;
import exceptions.MissedCommandArgumentException;

import java.text.CollationElementIterator;

class CommandParser {
    CollectionManager collectionM;
    public CommandParser(CollectionManager collectionM){
        this.collectionM = collectionM;
    }
    public void parse(String command) {
        command = command.trim();
        String[] array = command.split("\\s+");
        if (array[0].equals("add")) {
            if(array.length!=2) throw new MissedCommandArgumentException();
            if (array[1]=="" || array[1] == null) throw new InvalidCommandArgumentException("Command must contains name");
            collectionM.add(array[1]);
        }
        else if (array[0].equals("show")) {
            collectionM.show();
        } else System.out.println("Неизвестная команда");

    }
}
