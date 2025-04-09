package task02;

/**
 * The {@code Viewable} interface defines the contract for any class
 * that provides a view. It includes a method {@code getView()} to
 * retrieve the corresponding {@code View} instance.
 */
public interface Viewable {

    /**
     * Returns the {@code View} instance associated with this {@code Viewable} object.
     *
     * @return a {@code View} object that represents the view
     */
    View getView();
}
