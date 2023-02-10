package exceptions;

public class InvalidCommandArgumentException extends RuntimeException{
    public InvalidCommandArgumentException(String s){
        super(s);
    }
}
