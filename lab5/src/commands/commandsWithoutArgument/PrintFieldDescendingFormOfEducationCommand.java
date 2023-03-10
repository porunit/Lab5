package commands.commandsWithoutArgument;

import interfaces.Command;
import interfaces.CommandWithoutArgument;
import comparators.FormOfEducationComparator;
import data.FormOfEducation;
import executionManager.CollectionManager;

import java.util.ArrayList;

public class PrintFieldDescendingFormOfEducationCommand implements CommandWithoutArgument, Command {

    public void execute() {
        var groups = CollectionManager.getAll();
        ArrayList<FormOfEducation> formOfEducations = new ArrayList<>();
        for (var it : groups) {
            formOfEducations.add(it.getFormOfEducation());
        }
        formOfEducations.sort(new FormOfEducationComparator());
        for (var it : formOfEducations) {
            System.out.print(it + " | ");
        }
        System.out.println();
    }

    @Override
    public String getDescription() {
        return "print_field_descending_form_of_education : вывести значения поля formOfEducation всех элементов в порядке убывания";
    }
}