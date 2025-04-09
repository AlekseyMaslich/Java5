package task02;

import java.io.IOException;
import java.util.Scanner;

/**
 * The {@code Dialog} class provides a user interface to interact with the {@code View} object.
 * It allows the user to generate numbers, show results, calculate results, save and restore data,
 * and exit the application through a console-based menu.
 */
public class Dialog {
    /** The {@code Scanner} object for reading user input from the console. */
    private final transient Scanner scanner = new Scanner(System.in);

    /** The {@code View} object used to interact with the view. */
    private final View view;

    /**
     * Constructs a {@code Dialog} object with the specified {@code View}.
     *
     * @param view the view that will be used for interaction
     */
    public Dialog(View view) {
        this.view = view;
    }

    /**
     * Starts the interactive menu loop, allowing the user to choose different options:
     * 1. Generate numbers
     * 2. Show current results
     * 3. Calculate results
     * 4. Save results to a file
     * 5. Show saved results
     * 6. Quit the application
     */
    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: \n1. Generate numbers \n2. Show current Results \n3. Calculate results \n4. Save results \n5. Show saved results \n6. Quit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    view.viewInit();
                    view.show();
                    break;
                case 2:
                    view.show();
                    break;
                case 3:
                    view.viewCalculate();
                    view.show();
                    break;
                case 4:
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }

                    System.out.println("Object saved to file");
                    view.show();
                    break;
                case 5:
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }

                    System.out.println("Restored object: ");
                    view.show();
                    break;
                case 6:
                    System.out.println("Exit");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option was chosen");
                    break;
            }
        }
    }
}
