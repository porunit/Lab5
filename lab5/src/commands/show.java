package commands;

import data.StudyGroup;

import java.util.Stack;

public class Show {

    public static void show(Stack<StudyGroup> groupStack) {
        for(StudyGroup group: groupStack) {
            System.out.println(group.toString());
        }
    }
}
