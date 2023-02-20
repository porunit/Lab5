package executionManager;

import Interfaces.ICommandManager;
import commandEnums.Mode;
import data.Semester;

import java.time.format.DateTimeFormatter;

class CommandManager implements ICommandManager {
    protected CollectionManager collectionManager;
    private CommandDescriptionManager commandsDescription = new CommandDescriptionManager();
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
        }else if(mode == Mode.UPDATE) collectionManager.update(id);
        else if(mode == Mode.REMOVE)collectionManager.removeById(id);
    }

    public void add(String name) {
        if (!name.trim().equals("")) {
            collectionManager.add(name);
        }
    }

    public void show() {
        if(collectionManager.groupStack.empty()) System.out.println("Stack is empty");
        else collectionManager.show();
    }
    public void printFieldDescendingFormOfEducation(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else collectionManager.printFieldDescendingFormOfEducation();
    }

    public void printDescending(){
        if(collectionManager.groupStack.empty()) System.out.println("Collection is empty");
        else collectionManager.printDescending();
    }

    public void filterBySemesterEnum(String semesterString){
        try{
            Semester semester = Semester.valueOf(semesterString);
            collectionManager.filterBySemesterEnum(semester);
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
        collectionManager.load();
    }
    public void addIfMin(){
        collectionManager.addIfMin();
    }
    public void save(){
        collectionManager.save();
    }
    public void info(){
        System.out.println("type: Stack\n" +
                "creation date: "+ java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"\n" +
                "size: "+ collectionManager.groupStack.size()+
                "\n");
    }
    public void help() {
        commandsDescription.help();
        commandsDescription.idContainsCommands("", Mode.REMOVE);
        commandsDescription.idContainsCommands("",Mode.UPDATE);
        commandsDescription.add("");
        commandsDescription.clear();
        commandsDescription.info();
        commandsDescription.addIfMin();
        commandsDescription.filterBySemesterEnum("");
        commandsDescription.insertAt("");
        commandsDescription.printDescending();
        commandsDescription.printFieldDescendingFormOfEducation();
        commandsDescription.save();
    }

    @Override
    public void clear() {
        collectionManager.groupStack.clear();
    }
}

