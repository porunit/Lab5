package executionManager;

import Interfaces.ICommandManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import commandEnums.Mode;
import commands.*;
import data.Semester;


class CommandManager implements ICommandManager {
    protected CollectionManager collectionManager;

    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    public CommandManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


     public void idContainsCommands(String idString, Mode mode){
        long id = 0;
        boolean flag = false;
        try{
            id = Long.parseLong(idString);
        } catch (NumberFormatException e){
            System.out.println("id must be number");
            flag = true;
        }
        if (collectionManager.groupStack.empty() && !flag) System.out.println("Collection is empty");
        else if (!collectionManager.uniqueId.contains(id) && !flag) {
            System.out.println("id doesn't exists");
        }
        else if(mode == Mode.UPDATE) collectionManager.update(id);
        else if(mode == Mode.REMOVE) collectionManager.removeById(id);
    }

    public void add(String name) {
        if (!name.trim().equals("")) {
            collectionManager.add(name);
        }
    }

    public void show() {
        if(collectionManager.groupStack.empty()) System.out.println("Stack is empty");
        else Show.show(collectionManager.groupStack);
    }
    public void printFieldDescendingFormOfEducation(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else PrintFieldDescendingFormOfEducation.printFieldDescendingFormOfEducation(collectionManager.groupStack);
    }

    public void printDescending(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else PrintDescending.printDescending(collectionManager.groupStack);
    }

    public void filterBySemesterEnum(String semesterString){
        try{
            Semester semester = Semester.valueOf(semesterString);
            FilterBySemesterEnum.filterBySemesterEnum(semester,collectionManager.groupStack);
        }catch (IllegalArgumentException e){
            System.out.println("No such semester");
        }
    }
    public void insertAt(String parameter){
        try{
            int ind = Integer.parseInt(parameter);
            if(ind>collectionManager.groupStack.size() && collectionManager.groupStack.empty() ||
                    ind>collectionManager.groupStack.size()+1 && !collectionManager.groupStack.empty())
                System.out.println("index bigger than must be");
            else collectionManager.insertAt(ind);
        } catch (NumberFormatException | NullPointerException | StackOverflowError e) {
        System.out.println("Wrong index format");
        }
    }
    public void load(){
        collectionManager.groupStack = Load.load(mapper,collectionManager.uniqueId);
    }
    public void addIfMin(){
        collectionManager.addIfMin();
    }
    public void save(){
        Save.save(collectionManager.groupStack);
    }
    public void info(){
        Info.info(collectionManager.groupStack);
    }
    public void help() {
        Help.help();
    }
    public void clear() {
        collectionManager.clear();
    }
}

