package commands;

import data.StudyGroup;
import executionManager.CollectionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand {

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
        try (FileWriter writer = new FileWriter(setPath());
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("---\n");
            var groups = CollectionManager.getAll();
            for(StudyGroup group: groups) {
                bw.write(group.toString()+"\n");
            }
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
