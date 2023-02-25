package commands;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.StudyGroup;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

public class Load {

    private static void joinId(HashSet<Long> uniqueId, Stack<StudyGroup> groupStack){
        for (var it : groupStack) {
            uniqueId.add(it.getId());
        }
    }

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

    public static Stack<StudyGroup> load(ObjectMapper mapper, HashSet<Long> uniqueId) {
        String path = setPath();
        Stack<StudyGroup> groupStack = new Stack<>();
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
        joinId(uniqueId, groupStack);
        return groupStack;
    }
}
