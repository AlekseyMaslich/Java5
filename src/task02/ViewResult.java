package task02;

import task01.CalculationData;
import task01.Calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * The {@code ViewResult} class implements the {@code View} interface and provides functionality
 * for initializing, calculating, saving, restoring, and displaying numerical conversion results.
 */
public class ViewResult implements View {
    /** The file name used for storing serialized data. */
    private static final String FILE_NAME = "data.ser";

    /** The default number of elements to generate. */
    private static int SIZE = 10;

    /** List of calculation data objects. */
    private ArrayList<CalculationData> items = new ArrayList<>();

    /**
     * Constructs a {@code ViewResult} object with the default number of elements.
     */
    public ViewResult() {
        this(SIZE);
    }

    /**
     * Constructs a {@code ViewResult} object with a specified number of elements.
     *
     * @param n the number of elements to initialize
     */
    public ViewResult(int n) {
        SIZE = n;

        for (int i = 0; i < n; i++) {
            items.add(new CalculationData());
        }
    }

    /**
     * Returns the list of calculation data objects.
     *
     * @return the list of calculation data objects
     */
    @Override
    public ArrayList<CalculationData> getItems() {
        return items;
    }

    /**
     * Initializes the view by generating new random calculation data objects.
     */
    @Override
    public void viewInit() {
        items.clear();
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            int randomNumber = random.nextInt(1000 - 10 + 1) + 10;
            items.add(new CalculationData(randomNumber));
        }
    }

    /**
     * Performs numerical conversions on all stored calculation data objects.
     */
    @Override
    public void viewCalculate() {
        for (CalculationData item : items) {
            Calculator calculator = new Calculator(item);
            calculator.calculate();
        }
    }

    /**
     * Saves the current list of calculation data objects to a file via serialization.
     *
     * @throws IOException if an I/O error occurs during writing
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Restores the list of calculation data objects from a serialized file.
     *
     * @throws Exception if an I/O error occurs or the class of the serialized object cannot be found
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILE_NAME));
        items = (ArrayList<CalculationData>) is.readObject();
        is.close();
    }

    /**
     * Displays the numerical representations of all stored calculation data objects.
     */
    @Override
    public void show() {
        System.out.println("Results:");

        for (CalculationData item : items) {
            System.out.println(item);
        }

        System.out.println("All results are printed");
    }
}
