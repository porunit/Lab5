package commands.commandsWithoutArgument;

import data.StudyGroup;
import executionManager.CollectionManager;
import interfaces.CommandWithoutArgument;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements CommandWithoutArgument {

    public void execute() {
        try (FileWriter writer = new FileWriter(CollectionManager.getFilePath());
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("---\n");
            var groups = CollectionManager.getAll();
            for (StudyGroup group : groups) {
                bw.write(group.toString() + "\n");
            }
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.out.println("IOException catch, it may be due to lack of file permissions");
        }
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл";
    }
}
