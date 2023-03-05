package commands;

import comparators.StudyGroupComparator;
import executionManager.CollectionManager;

public class PrintDescendingCommand {
    public static void execute() {
        var groups = CollectionManager.getAll();
        var scomp = new StudyGroupComparator();
        groups.sort(scomp);
        for (var it:groups) {
            System.out.println(it);
        }
    }
}
