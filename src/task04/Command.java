package task04;

/**
 * The {@code Command} interface represents an executable action.
 * Implementing classes should define specific behaviors in the {@code execute} method.
 */
public interface Command {

    /**
     * Executes the command.
     * The specific implementation will define the behavior of the command.
     */
    void execute();
}
