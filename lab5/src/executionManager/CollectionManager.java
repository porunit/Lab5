package executionManager;

import Interfaces.ICollectionManager;
import comparators.EducationComparator;
import comparators.StudyGroupComparator;
import data.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.StudyGroup;

import java.io.*;
import java.util.*;

class CollectionManager implements ICollectionManager {
    protected Stack<StudyGroup> groupStack;
    protected HashSet<Long> uniqueId = new HashSet<>();
    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private String path;

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

        StudyGroup studyGroup = new StudyGroup(createID(), name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
        groupStack.add(studyGroup);
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

        StudyGroup group = new StudyGroup(createID(), name, coordinates, studentCount,formOfEducation,semester,groupAdmin);;
        return group;
    }
    public void add(String name, long id){
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

        StudyGroup studyGroup = new StudyGroup(id, name, coordinates, studentCount,formOfEducation,semester,groupAdmin);
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
            uniqueId.remove(id);
            for (var it : groupStack)
                if (it.getId() == id) {
                    group =it;
                }
            groupStack.remove(group);
        }
    }
    @Override
    public void clear() {
        groupStack.clear();
        uniqueId.clear();
    }

    @Override
    public void printFieldDescendingFormOfEducation() {
        ArrayList<FormOfEducation> array = new ArrayList<>();
        for (var it:groupStack) {
            array.add(it.getFormOfEducation());
        }
        var ecomp = new EducationComparator();
        array.sort(ecomp);
        for (var it:array) {
            System.out.print(it+" | ");
        }
    }

    @Override
    public void printDescending() {
        var scomp = new StudyGroupComparator();
        groupStack.sort(scomp);
        for (var it:groupStack) {
            System.out.println(it.toString());
        }
    }

    @Override
    public void filterBySemesterEnum(Semester semester) {
        var flag = false;
        for (var it: groupStack) {
            if (it.getSemester() == semester)
                System.out.println(it);
                 flag = true;
        }
        if(!flag) System.out.println("No-one suitable");
    }

    @Override
    public void addIfMin() {
        System.out.println("Weird command description");
    }

    @Override
    public void removeAt(int ind) {
        groupStack.remove(ind);
    }

    @Override
    public void insertAt(int ind) {
        groupStack.add(ind, add());
    }

    private long createID(){
        long id = uniqueId.size()+1;
        while(uniqueId.contains(id)) {
            id = id + 1;
        }
        uniqueId.add(id);
        return id;
    }
    private String setPath(){
        this.path = System.getenv("GOPATH");
        if (path == null) {
            System.out.println("""
                     Environment variable 'GOPATH' isn't  enable
                     Collection manager will use default path './study_group.yaml'                                   
                     """);
            path = "/Users/porunit/Desktop/Лабы/Программирование/student-18/Lab5/src/recources/study_group.yaml";
        }
        return path;
    }
    public void load() {
        try {
            groupStack = mapper.readValue(new File(setPath()), new TypeReference<Stack<StudyGroup>>() {});
            System.out.println("File was loaded");
        }
        catch (RuntimeException | DatabindException e) {
            System.out.println("'" + path + "' contains broken data");
            groupStack.clear();
        }
        catch (IOException e) {
            System.out.println("Unable to load '" + path + "' No such file\n");
        }
        joinId();
    }

    private void joinId(){
        for (var it : groupStack) {
            uniqueId.add(it.getId());
        }
    }

    public void save(){
        try (FileWriter writer = new FileWriter(setPath());
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("---\n");
            for(StudyGroup group: groupStack) {
                bw.write(group.toString()+"\n");
            }
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}


