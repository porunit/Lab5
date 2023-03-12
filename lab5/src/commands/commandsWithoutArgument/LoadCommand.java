package commands.commandswithoutargument;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import data.StudyGroup;
import exceptions.WrongDataTypeException;
import executionmanager.CollectionManager;
import interfaces.CommandWithoutArgument;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class LoadCommand implements CommandWithoutArgument {

    /**
     * Action for <b>load</b> command.
     * Doesn't receive arguments
     */
    public void execute() {
        String path = CollectionManager.getFilePath();
        Stack<StudyGroup> groupStack = new Stack<>();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            groupStack = mapper.readValue(new File(path), new TypeReference<Stack<StudyGroup>>() {
            });
            System.out.println("File was loaded");
        } catch (DatabindException e) {
            System.out.println("'" + path + "' contains broken data");
        } catch (IOException e) {
            System.out.println("Unable to load '" + path + "' No such file\n");
        }
        CollectionManager.load(groupStack);
        try {
            CollectionManager.joinId();
        } catch (WrongDataTypeException e) {
            System.out.println("ID's must be different");
        }
        CollectionManager.sort();
    }

    @Override
    public String getDescription() {
        return "load path: загрузить коллекцию из файла";
    }

}
