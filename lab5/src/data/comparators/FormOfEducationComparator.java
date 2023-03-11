package data.comparators;

import data.FormOfEducation;

import java.util.Comparator;

public class FormOfEducationComparator implements Comparator<FormOfEducation> {

    @Override
    public int compare(FormOfEducation o1, FormOfEducation o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.name().compareTo(o2.name());
    }
}

