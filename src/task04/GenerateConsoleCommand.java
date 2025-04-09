package task04;

import task02.View;

/**
 * The {@code GenerateConsoleCommand} class implements the {@code ConsoleCommand} interface
 * and represents a console command for generating and displaying random data.
 */
public class GenerateConsoleCommand implements ConsoleCommand {

    /** The view instance used to initialize and display data. */
    private final View view;

    /**
     * Constructs a {@code GenerateConsoleCommand} object with the specified view.
     *
     * @param view the view instance to be used for generating and displaying data
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Returns the character key associated with this command.
     *
     * @return the character 'g' representing this command
     */
    @Override
    public char getKey() {
        return 'g';
    }

    /**
     * Returns a string representation of this command.
     *
     * @return a formatted string representing the command
     */
    @Override
    public String toString() {
        return "'g'enerate";
    }

    /**
     * Executes the command by initializing the view with random data
     * and displaying the generated results.
     */
    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.show();
    }
}
