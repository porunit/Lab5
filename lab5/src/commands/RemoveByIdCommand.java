package commands;

import executionManager.CollectionManager;

public class RemoveByIdCommand {

    public static void execute(String idString){
        long id = 0;
        boolean flag = false;
        try {
            id = Long.parseLong(idString);
        } catch (NumberFormatException e) {
            System.out.println("id must be number");
            flag = true;
        }
        if (CollectionManager.checkId(id) && !flag) System.out.println("Collection is empty");
        else if(!CollectionManager.checkId(id))System.out.println("id doesn't exists");
        else CollectionManager.remove(id);
    }
}
