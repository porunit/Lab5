package Interfaces;

import commandEnums.Mode;

public interface ICommandManager {
    public void show();
    public void add(String name);
    public void idContainsCommands(String idString, Mode mode);
    public void printFieldDescendingFormOfEducation();
    public void printDescending();
    public void filterBySemesterEnum(String semesterString);
    public void insertAt(String parameter);
    public void addIfMin();
    public void save();
    public void info();
    public void help();
    public void clear();
}
