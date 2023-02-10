package commandManager;

import data.Color;
import data.FormOfEducation;

import java.util.Scanner;

public class InputManager {
    static Scanner scanner = new Scanner(System.in);

    static String input(String string){
        if(string.equals("x") || string.equals("y") || string.equals("z"))
            System.out.print(string+": ");
        else System.out.print("Введите " + string);
        return scanner.next().trim();
    }

}
