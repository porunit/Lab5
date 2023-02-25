package commands;

import comparators.StudyGroupComparator;
import data.StudyGroup;

import java.util.Stack;

public class PrintDescending {
    public static void printDescending(Stack<StudyGroup> groupStack) {
        var scomp = new StudyGroupComparator();
        groupStack.sort(scomp);
        for (var it:groupStack) {
            System.out.println(it);
        }
    }
}
