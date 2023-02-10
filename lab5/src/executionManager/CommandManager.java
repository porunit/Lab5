package commandManager;

import data.StudyGroup;
import exceptions.CommandException;
import exceptions.EmptyCollectionException;
import exceptions.InvalidCommandArgumentException;

public class CommandManager {
    CollectionManager collectionManager;
    public CommandManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void update(String idString){
        long id = 0;
        try{
            id = Long.valueOf(idString);
        } catch (NumberFormatException e){
            throw  new InvalidCommandArgumentException("id must be number");
        }
        if (collectionManager.groupStack.empty()) throw new EmptyCollectionException();
            collectionManager.update(id);
        } else throw new CommandException("Element with id:"+id+" doesn't exists");
    }
}
