package commands;

import data.Semester;
import executionManager.CollectionManager;

import java.util.NoSuchElementException;

public class FilterBySemesterEnumCommand {

    public static void execute(String argument) {
        Semester semester = null;
        try{
            semester = Semester.valueOf(argument);
        } catch(NoSuchElementException e){
            System.out.println("No such semester");
        }
        var groups = CollectionManager.getFilteredBySemesterEnum(semester);
        if(!groups.isEmpty()){
            for(var it : groups){
                System.out.println(it);
            }
        }
    }
}
