package interfaces;

public interface CommandWithArgument extends Command {
    void execute(String argument);
}
