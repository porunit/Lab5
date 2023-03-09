package commands.commandsWithoutArgument;

import Interfaces.Command;
import Interfaces.CommandWithoutArgument;
import data.*;
import executionManager.CollectionManager;
import executionManager.InputManager;

public class AddCommand implements CommandWithoutArgument, Command {

    public static StudyGroup add() {
        String name = InputManager.inputString(String.class, "Name(String):", false);
        Float x = InputManager.inputString(Float.class, "Coordinates\nx(Float): ", false, Coordinates.getMinX());
        Long y = InputManager.inputString(Long.class, "y(Long): ", false);
        Coordinates coordinates = new Coordinates(x, y);
        Integer studentCount = InputManager.inputString(Integer.class, "Students count(Integer): ", true);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class, "Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class, "Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class, "Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class, "Weight(Long): ", false, Person.getMinWeight());
        Color eyeColorAdmin = InputManager.inputEnum(Color.class, "Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class, "Location\nx(float): ", false);
        Integer yAdmin = InputManager.inputString(Integer.class, "y(Integer): ", false);
        int zAdmin = InputManager.inputString(Integer.class, "z(int): ", false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);
        return new StudyGroup(createID(), name, coordinates, studentCount, formOfEducation, semester, groupAdmin);
    }

    @Override
    public void execute() {
        CollectionManager.add(add());
    }

    private static long createID() {
        long id = CollectionManager.getAmountElements() + 1;
        while (CollectionManager.checkId(id)) {
            id = id + 1;
        }
        CollectionManager.appendId(id);
        return id;
    }

    @Override
    public String getDescription() {
        return "add : добавить новый элемент в коллекцию";
    }
}
