package commands;

import executionManager.CollectionManager;

public class ShowCommand {

    public static void show() {
        for(var group: CollectionManager.getAll()) {
            System.out.println(group.toString());
        }
    }
}
