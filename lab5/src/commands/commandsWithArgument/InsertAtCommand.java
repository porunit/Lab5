package commands.commandswithargument;

import commands.commandswithoutargument.AddCommand;
import executionmanager.CollectionManager;
import interfaces.CommandWithArgument;

public class InsertAtCommand implements CommandWithArgument {
    /**
     * Action for <b>insert_at</b> command.
     * Receive arguments
     *
     * @param argument command parameter
     */
    public void execute(String argument) {
        try {
            int index = Integer.parseInt(argument);
            if (index >= 0 && CollectionManager.isStackEmpty() ||
                    index > CollectionManager.getAmountElements() + 1 && !CollectionManager.isStackEmpty())
                System.out.println("index bigger than must be");
            else CollectionManager.insertAt(index, AddCommand.add());
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Wrong index format");
        }
    }

    @Override
    public String getDescription() {
        return "insert_at index {element} : добавить новый элемент в заданную позицию";
    }
}
