package task02;

import task01.CalculationData;

import java.io.IOException;
import java.util.Collection;

/**
 * The {@code View} interface defines the methods that must be implemented by
 * any class responsible for displaying and interacting with the view of the application.
 * It includes methods for initializing the view, performing calculations, saving and restoring data.
 */
public interface View {

    /**
     * Displays the results or the content of the view.
     */
    void show();

    /**
     * Performs calculations for the data displayed in the view.
     */
    void viewCalculate();

    /**
     * Saves the current state of the view to a file or storage medium.
     *
     * @throws IOException if an I/O error occurs during the saving process
     */
    void viewSave() throws IOException;

    /**
     * Restores the state of the view from a file or storage medium.
     *
     * @throws Exception if an error occurs during the restoration process
     */
    void viewRestore() throws Exception;

    /**
     * Initializes the view with necessary data or configurations.
     */
    void viewInit();

    /**
     * Returns the list of calculation data objects.
     *
     * @return the list of calculation data objects
     */
    Collection<CalculationData> getItems();
}
