package commands;

import comparators.EducationComparator;
import data.FormOfEducation;
import data.StudyGroup;

import java.util.ArrayList;
import java.util.Stack;

public class PrintFieldDescendingFormOfEducation {

    public static void printFieldDescendingFormOfEducation(Stack<StudyGroup> groupStack) {
        ArrayList<FormOfEducation> array = new ArrayList<>();
        for (var it:groupStack) {
            array.add(it.getFormOfEducation());
        }
        var ecomp = new EducationComparator();
        array.sort(ecomp);
        for (var it:array) {
            System.out.print(it+" | ");
        }
    }
}
