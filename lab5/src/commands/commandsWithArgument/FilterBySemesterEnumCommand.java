package commands.commandswithargument;

import data.Semester;
import executionmanager.CollectionManager;
import interfaces.CommandWithArgument;

import java.util.NoSuchElementException;

public class FilterBySemesterEnumCommand implements CommandWithArgument {

    public void execute(String argument) {
        Semester semester = null;
        try {
            semester = Semester.valueOf(argument);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("No such semester");
        }
        var groups = CollectionManager.getFilteredBySemesterEnum(semester);
        if (!groups.isEmpty()) {
            for (var it : groups) {
                System.out.println(it);
            }
        }
    }

    @Override
    public String getDescription() {
        return "filter_by_semester_enum semesterEnum : вывести элементы, значение поля semesterEnum которых равно заданному";
    }
}
