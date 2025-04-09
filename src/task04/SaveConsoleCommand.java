package task04;

import task02.View;
import java.io.IOException;

/**
 * The {@code SaveConsoleCommand} class implements the {@code ConsoleCommand} interface
 * and represents a console command for saving the current data.
 */
public class SaveConsoleCommand implements ConsoleCommand {

    /** The view instance used to save and display data. */
    private final View view;

    /**
     * Constructs a {@code SaveConsoleCommand} object with the specified view.
     *
     * @param view the view instance to be used for saving and displaying data
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Returns the character key associated with this command.
     *
     * @return the character 's' representing this command
     */
    @Override
    public char getKey() {
        return 's';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return a formatted string representing the command
     */
    @Override
    public String toString() {
        return "'s'ave";
    }

    /**
     * Executes the command by saving the current data.
     * If an error occurs during serialization, an error message is printed.
     */
    @Override
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization error: " + e);
        }
        view.show();
    }
}
