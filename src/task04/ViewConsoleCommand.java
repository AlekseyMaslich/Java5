package task04;

import task02.View;

/**
 * The {@code ViewConsoleCommand} class implements the {@code ConsoleCommand} interface
 * and represents a console command for displaying the current data.
 */
public class ViewConsoleCommand implements ConsoleCommand {

    /** The view instance used to display data. */
    private final View view;

    /**
     * Constructs a {@code ViewConsoleCommand} object with the specified view.
     *
     * @param view the view instance to be used for displaying data
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Returns the character key associated with this command.
     *
     * @return the character 'v' representing this command
     */
    @Override
    public char getKey() {
        return 'v';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return a formatted string representing the command
     */
    @Override
    public String toString() {
        return "'v'iew";
    }

    /**
     * Executes the command by displaying the current data.
     */
    @Override
    public void execute() {
        System.out.println("View current.");
        view.show();
    }
}
