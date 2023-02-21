package executionManager;


import java.util.Objects;
import java.util.Scanner;

class InputManager {
    private static final Scanner reader = new Scanner(System.in);

    private static String input(String message){
        System.out.print(message);
        String string = reader.nextLine();
        if(string == null || string.isBlank() || string.isEmpty())
            return null;
        return string.trim();
    }

    private static String input(){
        String string = reader.nextLine();
        if(string == null || string.isBlank() || string.isEmpty())
            return null;
        return string.trim();
    }


    protected static <T extends Enum<T>> T inputEnum(Class<T> enumName, String message, boolean isNullable){
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

    protected static <T> T inputString(Class<T> dataType, String message, boolean isNullable){
        while(true){
            System.out.print(message);
            try {
                if(dataType == String.class){
                    return (T) Objects.requireNonNull(InputManager.input());
                } else if (dataType == Double.class) {
                    return dataType.cast(Double.parseDouble(Objects.requireNonNull(InputManager.input())));
                } else if (dataType == Integer.class) {
                    return dataType.cast(Integer.parseInt(Objects.requireNonNull(InputManager.input())));
                } else if (dataType == Long.class) {
                    return dataType.cast(Long.parseLong(Objects.requireNonNull(InputManager.input())));
                } else if (dataType == Float.class) {
                    return dataType.cast(Float.parseFloat(Objects.requireNonNull(InputManager.input())));
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
}
