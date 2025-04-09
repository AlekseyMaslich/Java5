package task04;

import task02.View;

/**
 * The {@code RestoreConsoleCommand} class implements the {@code ConsoleCommand} interface
 * and represents a console command for restoring previously saved data.
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    /** The view instance used to restore and display data. */
    private final View view;

    /**
     * Constructs a {@code RestoreConsoleCommand} object with the specified view.
     *
     * @param view the view instance to be used for restoring and displaying data
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Returns the character key associated with this command.
     *
     * @return the character 'r' representing this command
     */
    @Override
    public char getKey() {
        return 'r';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return a formatted string representing the command
     */
    @Override
    public String toString() {
        return "'r'estore";
    }

    /**
     * Executes the command by restoring the last saved data.
     * If an error occurs during deserialization, an error message is printed.
     */
    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.show();
    }
}
