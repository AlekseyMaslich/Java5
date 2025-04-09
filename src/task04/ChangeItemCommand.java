package task04;

import task01.CalculationData;
import java.util.Random;

/**
 * The {@code ChangeItemCommand} class implements the {@code Command} interface and represents
 * a command that modifies a {@code CalculationData} object by setting its number to a new
 * randomly generated value within a specified range (10 to 1000).
 * This command is executed by calling the {@code execute} method.
 */
public class ChangeItemCommand implements Command {

    /** The {@code CalculationData} item to be modified. */
    private CalculationData item;

    /**
     * Sets the {@code CalculationData} item to be modified by this command.
     *
     * @param item the {@code CalculationData} object to be modified
     */
    public void setItem(CalculationData item) {
        this.item = item;
    }

    /**
     * Returns the {@code CalculationData} item that is modified by this command.
     *
     * @return the {@code CalculationData} item
     */
    public CalculationData getItem() {
        return item;
    }

    /**
     * Executes the command by generating a random number between 10 and 1000 and setting
     * it as the new value for the {@code CalculationData} item's number.
     */
    @Override
    public void execute() {
        int min = 10, max = 1000;
        Random random = new Random();
        int randomNum = random.nextInt(max - min + 1) + min;

        item.setNumber(randomNum);
    }
}
