package Interfaces;

import data.Semester;

public interface ICollectionManager {
    void show();
    void add(String name);
    void update(long id);
    void removeById(long id);
    void clear();
    void printFieldDescendingFormOfEducation();
    void printDescending();
    void filterBySemesterEnum(Semester semester);
    void addIfMin();
    void removeAt(int ind);
    void insertAt(int ind);



}
