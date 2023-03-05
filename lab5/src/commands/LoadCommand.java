package commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import data.StudyGroup;
import executionManager.CollectionManager;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class LoadCommand {
    private static String setPath(){
        String path = System.getenv("GOPATH");
        if (path == null) {
            System.out.println("""
                     Environment variable 'GOPATH' isn't  enable
                     Collection manager will use default path './study_group.yaml'                                   
                     """);
            path = "/Users/porunit/Desktop/Лабы/Программирование/student-18/Lab5/src/recources/study_group.yaml";
        }
        return path;
    }

    public static void execute() {
        String path = setPath();
        Stack<StudyGroup> groupStack = new Stack<>();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            groupStack = mapper.readValue(new File(setPath()), new TypeReference<Stack<StudyGroup>>() {});
            System.out.println("File was loaded");
        }
        catch (RuntimeException | DatabindException e) {
            System.out.println("'" + path + "' contains broken data");
            groupStack.clear();
        }
        catch (IOException e) {
            System.out.println("Unable to load '" + path + "' No such file\n");
        }
        CollectionManager.load(groupStack);
        CollectionManager.joinId();
    }
}
