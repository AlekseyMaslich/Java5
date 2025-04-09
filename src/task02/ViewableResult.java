package task02;

/**
 * The {@code ViewableResult} class implements the {@code Viewable} interface
 * and provides an implementation for the {@code getView} method, which returns
 * a {@code ViewResult} object.
 */
public class ViewableResult implements Viewable {

    /**
     * Returns a new instance of {@code ViewResult}.
     *
     * @return a new {@code ViewResult} object
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
