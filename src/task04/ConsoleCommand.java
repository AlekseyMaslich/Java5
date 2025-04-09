package task04;

/**
 * The {@code ConsoleCommand} interface extends the {@code Command} interface
 * and represents a command that can be executed via the console.
 * It includes a method to retrieve the command's associated key.
 */
public interface ConsoleCommand extends Command {

    /**
     * Returns the character key associated with this console command.
     *
     * @return the character key of the command
     */
    char getKey();
}
