package commands;

import executionManager.CollectionManager;

public class InsertAtCommand {
    public static void execute(String parameter){
        try{
            int index = Integer.parseInt(parameter);
            if(index> CollectionManager.getAmountElements() && CollectionManager.isStackEmpty() ||
                    index>CollectionManager.getAmountElements()+1 && !CollectionManager.isStackEmpty())
                System.out.println("index bigger than must be");
            else AddCommand.execute(index);
        } catch (NumberFormatException | NullPointerException | StackOverflowError e) {
            System.out.println("Wrong index format");
        }
    }
}
