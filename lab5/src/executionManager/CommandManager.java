package executionManager;

public class CommandManager {
    private CollectionManager collectionManager;
    public CommandManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void idContainsComands(String idString, String mode){
        long id = 0;
        boolean flag = false;
        try{
            id = Long.valueOf(idString);
        } catch (NumberFormatException e){
            System.out.println("id must be number");
            flag = true;
        }
        if (collectionManager.groupStack.empty() && !flag) System.out.println("Collection is empty");
        else if (!collectionManager.uniqueId.contains(id) && !flag) {
            System.out.println("id doesn't exists");
        }else if(mode.equals("update")) collectionManager.update(id);
        else if(mode.equals("remove"))collectionManager.removeById(id);
    }

    public void add(String name) {
        if (name.trim() != null && !name.trim().equals("")) {
            collectionManager.add(name);
        }
    }

    public void show() {
        if(collectionManager.groupStack.empty()) System.out.println("Stack is empty");
        else collectionManager.show();
    }


}

