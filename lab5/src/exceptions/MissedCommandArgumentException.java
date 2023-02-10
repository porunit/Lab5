package exceptions;

public class MissedCommandArgumentException extends InvalidCommandArgumentException{
    public MissedCommandArgumentException() {
        super("Missed command argument");
    }
}
