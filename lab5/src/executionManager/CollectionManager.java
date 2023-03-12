package executionmanager;

import data.Semester;
import data.StudyGroup;
import data.comparators.StudyGroupComparator;
import exceptions.WrongDataTypeException;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionManager {
    private static final HashSet<Long> uniqueId;
    private static final String creationDate;
    private static final String path;
    private static Stack<StudyGroup> groupStack;

    static {
        groupStack = new Stack<>();
        uniqueId = new HashSet<>();
        creationDate = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        path = System.getenv("GOPATH");
    }

    /**
     * sort collection
     */
    public static void sort() {
        groupStack.sort(new StudyGroupComparator());
    }

    /**
     * add StudyGroup element to collection
     *
     * @param group element for add
     */
    public static void add(StudyGroup group) {
        groupStack.add(group);
        sort();
    }

    /**
     * Removes the StudyGroup with the given ID from the collection
     *
     * @param id the ID of the StudyGroup to remove
     */
    public static void remove(long id) {
        StudyGroup groupForDel = null;
        for (var it : groupStack) {
            if (it.getId() == id) groupForDel = it;
        }
        groupStack.remove(groupForDel);
        uniqueId.remove(id);
    }

    /**
     * Clears the entire StudyGroup collection
     */
    public static void clear() {
        groupStack.clear();
        uniqueId.clear();
    }

    /**
     * Inserts a new StudyGroup at the specified index in the collection
     *
     * @param ind   the index at which to insert the StudyGroup
     * @param group the StudyGroup to insert
     */
    public static void insertAt(int ind, StudyGroup group) {
        groupStack.add(ind, group);
        sort();
    }

    /**
     * Checks if a StudyGroup with the given ID exists in the collection
     *
     * @param id the ID to check
     * @return true if a StudyGroup with the given ID exists in the collection, false otherwise
     */
    public static boolean checkId(long id) {
        return uniqueId.contains(id);
    }

    /**
     * Gets the number of StudyGroups in the collection
     *
     * @return the number of StudyGroups in the collection
     */
    public static int getAmountElements() {
        return uniqueId.size();
    }

    /**
     * Appends the given ID to the collection of unique IDs
     *
     * @param id the ID to append
     */
    public static void appendId(long id) {
        uniqueId.add(id);
    }

    /**
     * Gets all StudyGroups in the collection
     *
     * @return an ArrayList containing all StudyGroups in the collection
     */
    public static ArrayList<StudyGroup> getAll() {
        return new ArrayList<>(groupStack);
    }

    /**
     * Filters the StudyGroup collection by the given semester and returns the filtered list
     *
     * @param semester the semester to filter by
     * @return a List containing all StudyGroups in the collection with the given semester
     */
    public static List<StudyGroup> getFilteredBySemesterEnum(Semester semester) {
        List<StudyGroup> groups = new ArrayList<>();
        for (var it : groupStack) {
            if (it.getSemester() == semester) {
                groups.add(it);
            }
        }
        return groups;
    }

    /**
     * Checks if the StudyGroup collection is empty
     *
     * @return true if the StudyGroup collection is empty, false otherwise
     */
    public static boolean isStackEmpty() {
        return groupStack.isEmpty();
    }

    /**
     * Loads the given Stack into the StudyGroup collection
     *
     * @param stackToLoad the Stack to load into the collection
     */
    public static void load(Stack<StudyGroup> stackToLoad) {
        groupStack = stackToLoad;
    }

    /**
     * Joins the IDs of all StudyGroups in the collection into the collection of unique IDs
     *
     * @throws WrongDataTypeException if the collection already contains a StudyGroup with a given ID
     */
    public static void joinId() {
        ArrayList<Long> listId = new ArrayList<>();
        for (var it : groupStack) {
            if (listId.contains(it.getId())) {
                throw new WrongDataTypeException();
            }
            listId.add(it.getId());
        }
        uniqueId.addAll(listId);
    }

    /**
     * Gets the type of the StudyGroup collection
     *
     * @return the type of the StudyGroup collection
     */
    public static Class getCollectionType() {
        return groupStack.getClass();
    }

    /**
     * Gets the creation date of the StudyGroup collection
     *
     * @return the creation date of the StudyGroup collection
     */
    public static String getCreationDate() {
        return creationDate;
    }
  
    /**
     * Gets the file path of the StudyGroup collection
     *
     * @return the file path of the StudyGroup collection
     */
    public static String getFilePath() {
        return path;
    }

    /**
     * Gets the smallest unique ID in the collection
     *
     * @return the smallest unique ID in the collection
     */
    public static long getMinId() {
        return Collections.min(uniqueId);
    }
}


