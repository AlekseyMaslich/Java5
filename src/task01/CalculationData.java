package task01;

import java.io.Serializable;

/**
 * The {@code CalculationData} class stores a number and its representations
 * in different numeral systems: binary, octal, and hexadecimal.
 * It implements {@link Serializable} to support object serialization.
 */
public class CalculationData implements Serializable {

    /** The decimal number to be converted. */
    private int number;

    /** The binary representation of the number. */
    private String binary;

    /** The octal representation of the number. */
    private String octal;

    /** The hexadecimal representation of the number. */
    private String hexadecimal;

    /**
     * Constructs a new {@code CalculationData} object with the default value of 0.
     * Initializes numeral system representations accordingly.
     */
    public CalculationData() {
        this.number = 0;
        this.binary = Integer.toBinaryString(0);
        this.octal = Integer.toOctalString(0);
        this.hexadecimal = Integer.toHexString(0).toUpperCase();
    }

    /**
     * Constructs a new {@code CalculationData} object with the given number.
     * The default values for numeral system representations are initialized as zero.
     *
     * @param number the decimal number to be stored and converted
     */
    public CalculationData(int number) {
        this.number = number;
        this.binary = Integer.toBinaryString(number);
        this.octal = Integer.toOctalString(number);
        this.hexadecimal = Integer.toHexString(number).toUpperCase();
    }

    /**
     * Sets a new decimal number and updates all numeral system representations.
     *
     * @param number the new decimal number
     */
    public void setNumber (int number){
        this.number = number;
        this.binary = Integer.toBinaryString(number);
        this.octal = Integer.toOctalString(number);
        this.hexadecimal = Integer.toHexString(number).toUpperCase();
    }

    /**
     * Returns the stored decimal number.
     *
     * @return the decimal number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the binary representation of the number.
     *
     * @param binary the binary string to set
     */
    public void setBinary(String binary) {
        this.binary = binary;
    }

    /**
     * Sets the octal representation of the number.
     *
     * @param octal the octal string to set
     */
    public void setOctal(String octal) {
        this.octal = octal;
    }

    /**
     * Sets the hexadecimal representation of the number.
     *
     * @param hexadecimal the hexadecimal string to set
     */
    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    /**
     * Returns the binary representation of the number.
     *
     * @return the binary representation as a string
     */
    public String getBinary() {
        return binary;
    }

    /**
     * Returns the octal representation of the number.
     *
     * @return the octal representation as a string
     */
    public String getOctal() {
        return octal;
    }

    /**
     * Returns the hexadecimal representation of the number.
     *
     * @return the hexadecimal representation as a string
     */
    public String getHexadecimal() {
        return hexadecimal;
    }

    /**
     * Returns a string representation of the {@code CalculationData} object,
     * showing the number and its numeral system conversions.
     *
     * @return a formatted string representation of the object
     */
    @Override
    public String toString() {
        return "Number: " + number +
                "\tBinary: " + binary +
                "\tOctal: " + octal +
                "\tHexadecimal: " + hexadecimal;
    }
}
