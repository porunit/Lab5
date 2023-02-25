package commands;

import data.*;
import executionManager.InputManager;

import java.util.HashSet;

public class Add {
    HashSet<Long> uniqueId;
    public Add(HashSet<Long> uniqueId){
        this.uniqueId = uniqueId;
    }

    public StudyGroup add(String name){
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", true);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer): ",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int): ",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        return new StudyGroup(createID(), name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
    }
    public StudyGroup add(){
        String name = InputManager.inputString(String.class,"Name(String): ",false);
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", true);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer): ",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int): ",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        return new StudyGroup(createID(), name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
    }
    public StudyGroup add(String name, long id){
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", true);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer): ",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int): ",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        return new StudyGroup(id, name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
    }
    public StudyGroup add(long id){
        String name = InputManager.inputString(String.class,"Name(String):", false);
        Float x = InputManager.inputString(Float.class,"Coordinates\nx(Float): ", false);
        Long y = InputManager.inputString(Long.class,"y(Long): ", false);
        Coordinates coordinates = new Coordinates(x,y);
        Integer studentCount = InputManager.inputString(Integer.class,"Students count(Integer): ", true);
        FormOfEducation formOfEducation = InputManager.inputEnum(FormOfEducation.class,"Form of education(DISTANCE_EDUCATION,FULL_TIME_EDUCATION, EVENING_CLASSES): ", true);
        Semester semester = InputManager.inputEnum(Semester.class,"Semester(SECOND,THIRD,SIXTH): ", false);
        String nameAdmin = InputManager.inputString(String.class,"Group admin\nName(String): ", false);
        Long weightAdmin = InputManager.inputString(Long.class,"Weight(Long): ", false);
        Color eyeColorAdmin = InputManager.inputEnum(Color.class,"Eye color(RED,YELLOW,BLACK): ", true);
        float xAdmin = InputManager.inputString(Float.class,"Location\nx(float): ",false);
        Integer yAdmin = InputManager.inputString(Integer.class,"y(Integer): ",false);
        int zAdmin = InputManager.inputString(Integer.class,"z(int): ",false);

        Location location = new Location(xAdmin, yAdmin, zAdmin);
        Person groupAdmin = new Person(nameAdmin, weightAdmin, eyeColorAdmin, location);

        return new StudyGroup(id, name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
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
