import executionManager.ConsoleManager;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
        System.out.println(java.time.ZonedDateTime.now());
    }
}