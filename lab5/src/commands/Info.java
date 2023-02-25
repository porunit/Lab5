package commands;

import data.StudyGroup;

import java.time.format.DateTimeFormatter;
import java.util.Stack;

public class Info {

    public static void info(Stack<StudyGroup> groupStack){
        System.out.println("type: Stack\n" +
                "creation date: "+ java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"\n" +
                "size: "+ groupStack.size()+
                "\n");
    }
}
