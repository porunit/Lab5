package commands;

import data.StudyGroup;

import java.util.HashSet;
import java.util.Stack;

public class Update {

    public static boolean isUpdatable(long id, HashSet<Long> uniqueId, Stack<StudyGroup> groupStack) {
        if(uniqueId.contains(id)) {
            for (StudyGroup group : groupStack)
                if (group.getId() == id) {
                    groupStack.remove(group);
                    return true;
                }
        }
        return false;
    }
}
