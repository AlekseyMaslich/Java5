package task04;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 * The {@code Menu} class implements the {@code Command} interface and represents a console menu
 * that allows the user to interact with various {@code ConsoleCommand} objects.
 * The menu continuously prompts the user for a command and executes the corresponding action.
 */
public class Menu implements Command {

    /** A list of available console commands. */
    private final ArrayList<ConsoleCommand> menu = new ArrayList<>();

    /**
     * A {@code BufferedReader} used for reading user input from the console.
     * This field is initialized either with a default reader using {@code System.in}
     * or can be set to a custom reader using the {@code setReader} method.
     */
    private BufferedReader reader;

    /**
     * Constructs a {@code Menu} object with the default {@code BufferedReader}
     * using {@code System.in} for reading user input.
     */
    public Menu() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Constructs a {@code Menu} object with a custom {@code BufferedReader}.
     * This allows for the injection of a custom input source, typically for testing purposes.
     *
     * @param reader the {@code BufferedReader} to read user input from
     */
    public Menu(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Adds a {@code ConsoleCommand} to the menu.
     *
     * @param command the console command to be added
     * @return the added {@code ConsoleCommand}
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    /**
     * Returns a string representation of the menu, showing available commands.
     *
     * @return a formatted string representing the menu
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Enter command...\n");

        for (ConsoleCommand c : menu) {
            s.append(c).append(", ");
        }

        s.append("'q'uit: ");
        return s.toString();
    }

    /**
     * Executes the menu by continuously prompting the user for input and executing the
     * corresponding console command based on the user's input.
     */
    @Override
    public void execute() {
        while (true) {
            System.out.print(this);
            String input;

            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.err.println("Error reading input: " + e.getMessage());
                return;
            }

            if (input == null || input.length() != 1) {
                System.out.println("Invalid input. Please enter a single character.");
                continue;
            }

            char key = input.charAt(0);

            if (key == 'q') {
                System.out.println("Exiting...");
                break;
            }

            boolean commandFound = false;
            for (ConsoleCommand command : menu) {
                if (key == command.getKey()) {
                    command.execute();
                    commandFound = true;
                    break;
                }
            }

            if (!commandFound) {
                System.out.println("Invalid command. Try again.");
            }
        }
    }

    /**
     * Sets the {@code BufferedReader} to be used for reading user input in the menu.
     * This allows the menu to be tested with simulated input or use a different reader
     * than the default {@code System.in} stream.
     *
     * @param reader the {@code BufferedReader} to be used for reading input
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
