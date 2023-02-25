package commands;

import data.Semester;
import data.StudyGroup;

import java.util.Stack;

public class FilterBySemesterEnum {

    public static void filterBySemesterEnum(Semester semester, Stack<StudyGroup> groupStack) {
        var flag = false;
        for (var it: groupStack) {
            if (it.getSemester() == semester)
                System.out.println(it);
            flag = true;
        }
        if(!flag) System.out.println("No-one suitable");
    }
}
