package comparators;

import data.FormOfEducation;

import java.util.Comparator;

public class EducationComparator implements Comparator<FormOfEducation> {
    @Override
    public int compare(FormOfEducation o1, FormOfEducation o2) {
        if(o1 == null && o2 == null) return 0;
        else if (o1 == null) return -1;
        else if (o2 == null) return 1;
        return o1.getFirstLetter().compareTo(o2.getFirstLetter());
    }
}
