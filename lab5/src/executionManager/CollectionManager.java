package executionManager;

import Interfaces.ICollectionManager;
import data.*;

import java.util.HashSet;
import java.util.Stack;

class CollectionManager implements ICollectionManager {
    protected Stack<StudyGroup> groupStack;
    protected HashSet<Long> uniqueId = new HashSet<>();
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
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", false);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer)",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int)",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        StudyGroup studyGroup = new StudyGroup(createID(), name, coordinates, java.time.ZonedDateTime.now(),studentCount,formOfEducation,semester,groupAdmin);
        groupStack.add(studyGroup);
    }

    public void add(String name, long id){
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", false);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer)",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int)",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        StudyGroup studyGroup = new StudyGroup(id, name, coordinates, java.time.ZonedDateTime.now(),studentCount,formOfEducation,semester,groupAdmin);
        groupStack.add(studyGroup);
    }
    @Override
    public void update(long id) {
        if(uniqueId.contains(id)) {
            for (StudyGroup group : groupStack)
                if (group.getId() == id) {
                    groupStack.remove(group);
                    add(InputManager.inputString(String.class,"Имя: ", false),id);
                }
        }
    }
    public void removeById(long id){
        StudyGroup group = null;
        if(uniqueId.contains(id)) {
            for (var it : groupStack)
                if (it.getId() == id) {
                    group =it;
                }
            assert group != null;
            groupStack.remove(group);
        }
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

