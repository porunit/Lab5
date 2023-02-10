package exceptions;

public class WrongDataTypeException extends RuntimeException{
    public WrongDataTypeException(String s){
        super(s);
    }
}
