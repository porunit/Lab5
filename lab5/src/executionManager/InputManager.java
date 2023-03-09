package executionManager;


import java.util.Objects;
import java.util.Scanner;

public class InputManager {
    private static final Scanner reader = new Scanner(System.in);

    private static String input(String message){
        System.out.print(message);
        return input();
    }

    private static String input(){
        String string = reader.nextLine();
        if(string == null || string.isBlank() || string.isEmpty())
            return null;
        return string.trim();
    }


    public static <T extends Enum<T>> T inputEnum(Class<T> enumName, String message, boolean isNullable){
        while(true){
            var value = InputManager.input(message);
            try{
                return (T) Enum.valueOf(enumName, Objects.requireNonNull(value));
            } catch (IllegalArgumentException | NullPointerException e) {
                if(isNullable && value == null) return null;
               else System.out.println("Incorrect input");
            }
        }
    }

    public static <T> T inputString(Class<T> dataType, String message, boolean isNullable){
        while(true){
            System.out.print(message);
            var argument = InputManager.input();
            try {
                if(dataType == String.class){
                    return (T) Objects.requireNonNull(argument);
                } else if (dataType == Double.class) {
                    return dataType.cast(Double.parseDouble(Objects.requireNonNull(argument)));
                } else if (dataType == Integer.class) {
                    return dataType.cast(Integer.parseInt(Objects.requireNonNull(argument)));
                } else if (dataType == Long.class) {
                    return dataType.cast(Long.parseLong(Objects.requireNonNull(argument)));
                } else if (dataType == Float.class) {
                    return dataType.cast(Float.parseFloat(Objects.requireNonNull(argument)));
                } else {
                    System.out.println("Unsupported number class");
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input format");
            }
            catch (NullPointerException e){
                if(!isNullable) System.out.println("Incorrect input format");
                else return null;
            }
        }
    }

    public static <T> T inputString(Class<T> dataType, String message, boolean isNullable, int limit){
        while(true){
            System.out.print(message);
            var argument = InputManager.input();
            try {
                T parsedArgument = null;
                if(dataType == String.class){
                    return (T) Objects.requireNonNull(argument);
                } else if (dataType == Double.class) {
                    parsedArgument = dataType.cast(Double.parseDouble(Objects.requireNonNull(argument)));
                } else if (dataType == Integer.class) {
                    parsedArgument = dataType.cast(Integer.parseInt(Objects.requireNonNull(argument)));
                } else if (dataType == Long.class) {
                    parsedArgument = dataType.cast(Long.parseLong(Objects.requireNonNull(argument)));
                    if((long)parsedArgument<limit) System.out.println("Wrong data");
                } else if (dataType == Float.class) {
                    parsedArgument = dataType.cast(Float.parseFloat(Objects.requireNonNull(argument)));
                }
                    return parsedArgument;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input format");
            }
            catch (NullPointerException e){
                if(!isNullable) System.out.println("Incorrect input format");
                else return null;
            }
        }
    }
}
