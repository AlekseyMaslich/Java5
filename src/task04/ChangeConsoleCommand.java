package task04;

import task01.CalculationData;
import task02.View;
import task02.ViewResult;

/**
 * The {@code ChangeConsoleCommand} class extends {@code ChangeItemCommand} and implements
 * the {@code ConsoleCommand} interface. It represents a command to change the values of
 * {@code CalculationData} items within a {@code ViewResult} by generating a random number
 * for each item and updating its value. This command is executed when the user selects the
 * corresponding key ('c') in the menu.
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {

    /** The {@code View} object used to display the result and hold the {@code CalculationData} items. */
    private View view;

    /**
     * Returns the {@code View} associated with this command.
     *
     * @return the {@code View} object
     */
    public View getView() {
        return view;
    }

    /**
     * Sets the {@code View} for this command.
     *
     * @param view the {@code View} object to be set
     * @return the {@code View} object that was set
     */
    public View setView(View view) {
        return this.view = view;
    }

    /**
     * Constructs a new {@code ChangeConsoleCommand} with the specified {@code View} object.
     *
     * @param view the {@code View} to be used for displaying and updating items
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Returns the key associated with this command. The key 'c' represents this command.
     *
     * @return the key 'c'
     */
    @Override
    public char getKey() {
        return 'c';
    }

    /**
     * Returns a string representation of the command. It returns the string "'c'hange".
     *
     * @return the string "'c'hange"
     */
    @Override
    public String toString() {
        return "'c'hange";
    }

    /**
     * Executes the command by changing the {@code CalculationData} items within the
     * {@code ViewResult} using the {@code ChangeItemCommand}. Each item in the view is
     * updated with a new random number, and then the updated view is displayed.
     */
    @Override
    public void execute() {
        System.out.println("Changing items: ");

        for (CalculationData item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }

        view.show();
    }
}
