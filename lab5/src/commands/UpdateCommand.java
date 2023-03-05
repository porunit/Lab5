package commands;

import executionManager.CollectionManager;

public class UpdateCommand {

    public static void execute(String idString) {
        long id = 0;
        boolean isArgString = true;
        try {
            id = Long.parseLong(idString);
        } catch (NumberFormatException e) {
            System.out.println("id must be number");
            return;
        }
        if (CollectionManager.isStackEmpty()) System.out.println("Collection is empty");
        else if (!CollectionManager.checkId(id) && isArgString)System.out.println("id doesn't exists");
        else {
            var group = AddCommand.execute(id);
            CollectionManager.add(group);
            CollectionManager.remove(id, group);
        }
    }
}
