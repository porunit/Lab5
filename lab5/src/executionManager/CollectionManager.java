package executionManager;

import data.Semester;
import data.StudyGroup;

import java.util.*;

public class CollectionManager {
    private static Stack<StudyGroup> groupStack;
    private static HashSet<Long> uniqueId;

    static {
        groupStack = new Stack<>();
        uniqueId = new HashSet<>();
    }

    public static void add(StudyGroup group){
        groupStack.add(group);
    }

    public static void remove(long id, StudyGroup group) {
        groupStack.remove(group);
        uniqueId.remove(id);
    }
    public static void remove(long id){
        for(var it : groupStack){
            if (it.getId() == id) groupStack.remove(it);
        }
    }
    public static void clear() {
        groupStack.clear();
        uniqueId.clear();
    }

    public void addIfMin() {
        System.out.println("Weird command description");
    }

    public static void insertAt(int ind, StudyGroup group){
        groupStack.add(ind,group);
    }

    public static boolean checkId(long id){
        return uniqueId.contains(id);
    }

    public static int getAmountElements(){
        return uniqueId.size();
    }
    public static void appendId(long id){
        uniqueId.add(id);
    }
    public static List<StudyGroup> getAll(){
        List<StudyGroup> groups = new ArrayList<>();
        for(var it: groupStack) {
            groups.add(it);
        }
        return groups;
    }
    public static List getFilteredBySemesterEnum(Semester semester) {
        List<StudyGroup> groups = new ArrayList<>();
        for (var it: groupStack) {
            if (it.getSemester() == semester) {
                groups.add(it);
            }
        }
        return groups;
    }

    public static boolean isStackEmpty(){
        return groupStack.isEmpty();
    }

    public static void load(Stack<StudyGroup> loadedStack){
        groupStack =  loadedStack;
    }
    public static void joinId(){
        for (var it : groupStack) {
            uniqueId.add(it.getId());
        }
    }
}


