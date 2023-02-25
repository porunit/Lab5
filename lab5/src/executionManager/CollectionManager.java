package executionManager;

import commands.*;
import data.StudyGroup;

import java.util.*;

class CollectionManager {
    protected Stack<StudyGroup> groupStack;
    protected HashSet<Long> uniqueId = new HashSet<>();

    public CollectionManager(Stack<StudyGroup> stack){
        this.groupStack = stack;
    }

    public void add(String name){
      groupStack.add(new Add(uniqueId).add(name));
    }

    public StudyGroup add(){
        return new Add(uniqueId).add();
    }

    public void add(long id){
        groupStack.add(new Add(uniqueId).add(id));
    }

    public void update(long id) {
        if(Update.isUpdatable(id,uniqueId,groupStack))
            add(id);
    }
    public void removeById(long id){
        Remove.removeById(id,groupStack,uniqueId);
    }

    public void clear() {
        groupStack.clear();
        uniqueId.clear();
    }

    public void addIfMin() {
        System.out.println("Weird command description");
    }

    public void insertAt(int ind) {
        groupStack.add(ind, add());
    }

}


