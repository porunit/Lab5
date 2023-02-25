package commands;

import data.StudyGroup;

import java.util.HashSet;
import java.util.Stack;

public class Remove {

    public static void removeById(long id, Stack<StudyGroup> groupStack, HashSet<Long> uniqueId){
        StudyGroup group = null;
        if(uniqueId.contains(id)) {
            uniqueId.remove(id);
            for (var it : groupStack)
                if (it.getId() == id) {
                    group =it;
                }
            groupStack.remove(group);
        }
    }
}
