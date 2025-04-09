package task04;

import task02.View;
import task03.ViewableTable;

/**
 * The {@code Application} class represents the main entry point for the application.
 * It follows the Singleton design pattern to ensure that only one instance of the application exists.
 * The application initializes the console menu and provides functionality to interact with various commands.
 */
public class Application {

    /** The single instance of the {@code Application} class (Singleton pattern). */
    private final static Application instance = new Application();

    /**
     * Private constructor to prevent instantiation.
     * This constructor ensures that only one instance of {@code Application} is created.
     */
    private Application() {}

    /**
     * Returns the singleton instance of the {@code Application}.
     *
     * @return the single instance of {@code Application}
     */
    public static Application getInstance() {
        return instance;
    }

    /** The view used for displaying results. */
    private final View view = new ViewableTable().getView();

    /** The menu containing all available console commands. */
    private final Menu menu = new Menu();

    /**
     * Runs the application by adding commands to the menu and executing the menu.
     * It sets up the available commands such as viewing, generating, changing, saving, and restoring data.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}
