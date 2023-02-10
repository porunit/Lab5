package commandManager;

import Interfaces.ICollectionManager;
import data.*;
import exceptions.CommandException;
import exceptions.EmptyCollectionException;
import exceptions.InvalidCommandArgumentException;

import java.util.HashSet;
import java.util.Stack;

class CollectionManager implements ICollectionManager {
    protected Stack<StudyGroup> groupStack;
    private HashSet<Long> uniqueId = new HashSet<>();
    public CollectionManager(Stack<StudyGroup> stack){
        this.groupStack = stack;
    }

    @Override
    public void show() {
        for(StudyGroup group: groupStack) {
            System.out.println(group.toString());
        }
    }

    public void add(String name){
        Float x = Float.parseFloat(InputManager.input("координаты\nx: "));
        Long y = Long.valueOf(InputManager.input("y"));
        Integer studentCount = Integer.valueOf(InputManager.input("количество студентов: "));
        FormOfEducation formOfEducation = FormOfEducation.valueOf(InputManager.input("форму обучения(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): "));
        Semester semester = Semester.valueOf(InputManager.input("номер семестра(SECOND,THIRD,SIXTH): "));
        String nameAdmin = InputManager.input("данные о старосте\nВведите имя: ");
        Long weightAdmin = Long.valueOf(InputManager.input("вес: "));
        Color eyeColorAdmin = Color.valueOf(InputManager.input("цвет глаз: "));
        float xAdmin = Float.parseFloat(InputManager.input("локацию\nx: "));
        Integer yAdmin = Integer.valueOf(InputManager.input("y"));
        int zAdmin = Integer.parseInt(InputManager.input("z"));

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);
        Coordinates coordinates = new Coordinates(x,y);
        StudyGroup studyGroup = new StudyGroup(createID(), name, coordinates, java.time.ZonedDateTime.now(),studentCount,formOfEducation,semester,groupAdmin);
        groupStack.push(studyGroup);
    }

    @Override
    public void update(long id) {
        if(uniqueId.contains(id)) {
            for (StudyGroup group : groupStack)
                if (group.getId() == id) add(InputManager.input("Имя: "));
        }
    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void save() {

    }
    private long createID(){
        long id = uniqueId.size()+1;
        while(uniqueId.contains(id)) {
            id = id + 1;
        }
        uniqueId.add(id);
        return id;
    }
}

