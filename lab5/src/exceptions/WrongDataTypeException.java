package exceptions;

public class WrongDataTypeException extends RuntimeException {
    public WrongDataTypeException() {
        super("Wrong data type");
    }
}
