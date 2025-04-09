package task03;

import task01.CalculationData;
import task02.ViewResult;

import java.util.ArrayList;

/**
 * The {@code ViewTable} class extends {@code ViewResult} and provides functionality
 * to display the results of calculations in a table format. It supports customizable
 * table width and displays results in multiple lines if necessary for binary, octal,
 * and hexadecimal values.
 */
public class ViewTable extends ViewResult {

    /** Default width for the table columns. */
    private static final int DEFAULT_WIDTH = 5;

    /** The width of the table columns. */
    private int width;

    /**
     * Constructs a {@code ViewTable} instance with the default width.
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * Constructs a {@code ViewTable} instance with a specified width.
     *
     * @param width the width of the table columns
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Constructs a {@code ViewTable} instance with a specified width and the
     * number of items to display.
     *
     * @param width the width of the table columns
     * @param n the number of items to display
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /**
     * Sets the width of the table columns.
     *
     * @param width the new width of the table columns
     * @return the updated width
     */
    public int setWidth(int width) {
        return this.width = width;
    }

    /**
     * Returns the current width of the table columns.
     *
     * @return the width of the table columns
     */
    public int getWidth() {
        return width;
    }

    /**
     * Prints a line to separate table rows.
     */
    private void outLine() {
        System.out.println("-".repeat((width + 3) * 4 + 1)); // Adjust for spacing
    }

    /**
     * Prints the header of the table with column names.
     */
    private void outHeader() {
        System.out.printf("| %s | %s | %s | %s |\n",
                formatCenteredHeader("Number"),
                formatCenteredHeader("Binary"),
                formatCenteredHeader("Octal"),
                formatCenteredHeader("Hexadecimal"));
    }

    /**
     * Formats the column header text to be centered within the specified width.
     *
     * @param header the header text to format
     * @return the formatted header text
     */
    private String formatCenteredHeader(String header) {
        return formatCenteredText(header.length() > width ? header.substring(0, width) : header, width);
    }

    /**
     * Prints the body of the table, displaying each calculation result.
     */
    private void outBody() {
        for (CalculationData item : super.getItems()) {
            printMultiLineRow(item);
            outLine();
        }
    }

    /**
     * Prints a row for a single {@code CalculationData} object, handling multi-line
     * output if the binary, octal, or hexadecimal values exceed the specified width.
     *
     * @param item the {@code CalculationData} object to display
     */
    private void printMultiLineRow(CalculationData item) {
        String[] binaryLines = splitToChunks(item.getBinary(), width);
        String[] octalLines = splitToChunks(item.getOctal(), width);
        String[] hexLines = splitToChunks(item.getHexadecimal(), width);

        int maxLines = Math.max(binaryLines.length, Math.max(octalLines.length, hexLines.length));

        for (int i = 0; i < maxLines; i++) {
            String numStr = (i == 0) ? formatCenteredText(String.valueOf(item.getNumber()), width) : " ".repeat(width);
            String binaryStr = (i < binaryLines.length) ? binaryLines[i] : " ".repeat(width);
            String octalStr = (i < octalLines.length) ? octalLines[i] : " ".repeat(width);
            String hexStr = (i < hexLines.length) ? hexLines[i] : " ".repeat(width);

            System.out.printf("| %s | %s | %s | %s |\n", numStr, binaryStr, octalStr, hexStr);
        }
    }

    /**
     * Formats a string to be centered within the specified width, adding padding as needed.
     *
     * @param text the text to format
     * @param width the width within which the text should be centered
     * @return the formatted text
     */
    private String formatCenteredText(String text, int width) {
        int padding = (width - text.length()) / 2;
        int extraPadding = (width - text.length()) % 2;

        return " ".repeat(padding) + text + " ".repeat(padding + extraPadding);
    }

    /**
     * Splits a string into chunks of the specified size, ensuring each chunk is centered.
     *
     * @param str the string to split
     * @param chunkSize the size of each chunk
     * @return an array of strings representing the chunks
     */
    private String[] splitToChunks(String str, int chunkSize) {
        int len = str.length();
        int numChunks = (int) Math.ceil((double) len / chunkSize);
        String[] chunks = new String[numChunks];

        for (int i = 0; i < numChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, len);
            chunks[i] = formatCenteredText(str.substring(start, end), chunkSize);
        }

        return chunks;
    }

    /**
     * Displays the table with headers and the body of the calculation results.
     */
    @Override
    public void show() {
        outHeader();
        outLine();
        outBody();
    }

    /**
     * Initializes the view with the specified column width.
     *
     * @param width the width of the table columns
     */
    public final void viewInit(int width) {
        this.width = width;
        viewInit();
    }

    /**
     * Initializes the view, preparing the data for display.
     */
    @Override
    public void viewInit() {
        System.out.print("Initialization... ");
        super.viewInit();
        System.out.println("Done. ");
    }
}
