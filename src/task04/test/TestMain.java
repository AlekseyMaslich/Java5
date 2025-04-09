package task04.test;

import task04.*;
import task02.View;
import task03.ViewableTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code TestMain} class contains unit tests to verify the behavior of the commands
 * and console-related functionality within the {@code task04} package.
 */
public class TestMain {

    private Menu menu;
    private View view;

    @BeforeEach
    public void setUp() {
        view = new ViewableTable().getView();
        menu = new Menu();
    }

    /**
     * Tests the functionality of the {@code GenerateConsoleCommand}.
     * Verifies that it generates the expected key ('g') and performs the view initialization.
     */
    @Test
    public void testGenerateConsoleCommand() {
        GenerateConsoleCommand command = new GenerateConsoleCommand(view);
        assertEquals('g', command.getKey(), "The key should be 'g'");
        command.execute();
        assertFalse(view.getItems().isEmpty(), "The view should contain items after execution");
    }

    /**
     * Tests the functionality of the {@code RestoreConsoleCommand}.
     * Verifies that it generates the expected key ('r') and attempts to restore a view.
     */
    @Test
    public void testRestoreConsoleCommand() {
        RestoreConsoleCommand command = new RestoreConsoleCommand(view);
        assertEquals('r', command.getKey(), "The key should be 'r'");
        command.execute();
    }

    /**
     * Tests the functionality of the {@code SaveConsoleCommand}.
     * Verifies that it generates the expected key ('s') and saves the current view.
     */
    @Test
    public void testSaveConsoleCommand() {
        SaveConsoleCommand command = new SaveConsoleCommand(view);
        assertEquals('s', command.getKey(), "The key should be 's'");
        command.execute();
    }

    /**
     * Tests the functionality of the {@code ViewConsoleCommand}.
     * Verifies that it generates the expected key ('v') and displays the current view.
     */
    @Test
    public void testViewConsoleCommand() {
        ViewConsoleCommand command = new ViewConsoleCommand(view);
        assertEquals('v', command.getKey(), "The key should be 'v'");
        command.execute();
    }

    /**
     * Tests the functionality of the {@code Menu} class.
     * Verifies that the menu correctly processes user input and executes the appropriate command.
     * This test simulates user input to avoid the infinite loop.
     */
    @Test
    public void testMenu() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));

        String simulatedInput = "g\nq";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        menu.setReader(reader);

        try {
            menu.execute();
        } catch (Exception e) {
            fail("Exception was thrown during menu execution: " + e.getMessage());
        }
    }

    /**
     * Tests the behavior when an invalid key is entered in the menu.
     * Verifies that the menu prompts the user for a valid command.
     */
    @Test
    public void testInvalidKeyInMenu() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));

        String simulatedInput = "x\nq";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        menu.setReader(reader);

        try {
            menu.execute();
        } catch (Exception e) {
            fail("Exception was thrown during menu execution: " + e.getMessage());
        }
    }
}
