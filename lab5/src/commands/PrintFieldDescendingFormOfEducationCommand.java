package commands;

import comparators.EducationComparator;
import data.FormOfEducation;
import executionManager.CollectionManager;

import java.util.ArrayList;

public class PrintFieldDescendingFormOfEducationCommand {

    public static void execute() {
        var groups = CollectionManager.getAll();
        ArrayList<FormOfEducation> array = new ArrayList<>();
        for (var it:groups) {
            array.add(it.getFormOfEducation());
        }
        var eComp = new EducationComparator();
        array.sort(eComp);
        for (var it:array) {
            System.out.print(it+" | ");
        }
    }
}
