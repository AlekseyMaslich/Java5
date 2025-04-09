package task04;

/**
 * The {@code Main} class serves as the entry point of the application.
 * It retrieves the singleton instance of the {@code Application} class and runs the application.
 */
public class Main {

    /**
     * The main method is the entry point for the program.
     * It retrieves the singleton instance of {@code Application} and calls its {@code run} method to start the application.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}
