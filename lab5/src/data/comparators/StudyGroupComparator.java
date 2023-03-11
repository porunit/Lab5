package data.comparators;

import data.StudyGroup;

import java.util.Comparator;

public class StudyGroupComparator implements Comparator<StudyGroup> {

    public int compare(StudyGroup sg1, StudyGroup sg2) {
        return Long.compare(sg1.getId(), sg2.getId());
    }
}
