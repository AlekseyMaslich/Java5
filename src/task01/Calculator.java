package task01;

import java.io.*;

/**
 * The {@code Calculator} class performs numerical conversions and allows for serialization
 * and deserialization of {@link CalculationData} objects.
 */
public class Calculator {
    /** The file name used for storing serialized data. */
    private static final String FILE_NAME = "data.ser";

    /** The calculation data object storing numerical representations. */
    private CalculationData data;

    /**
     * Constructs a {@code Calculator} with the specified {@code CalculationData} object.
     *
     * @param data the calculation data object containing the number to process
     */
    public Calculator(CalculationData data) {
        this.data = data;
    }

    /**
     * Performs numeral system conversions for the stored number.
     * Converts the number into binary, octal, and hexadecimal formats.
     */
    public void calculate() {
        int number = data.getNumber();
        data.setBinary(Integer.toBinaryString(number));
        data.setOctal(Integer.toOctalString(number));
        data.setHexadecimal(Integer.toHexString(number).toUpperCase());
    }

    /**
     * Returns the {@code CalculationData} object containing the numerical results.
     *
     * @return the calculation data object
     */
    public CalculationData getResult() {
        return data;
    }

    /**
     * Saves the current {@code CalculationData} object to a file via serialization.
     *
     * @throws IOException if an I/O error occurs during writing
     */
    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(data);
        }
    }

    /**
     * Restores the {@code CalculationData} object from a serialized file.
     *
     * @throws IOException if an I/O error occurs during reading
     * @throws ClassNotFoundException if the class of the serialized object cannot be found
     */
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            this.data = (CalculationData) in.readObject();
        }
    }

    /**
     * Displays the numerical representations of the stored number.
     */
    public void showData() {
        System.out.println(data);
    }
}