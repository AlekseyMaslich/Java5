package task03;

import task02.View;
import task02.ViewableResult;

/**
 * The {@code ViewableTable} class extends {@code ViewableResult} and provides
 * a method to retrieve a {@code ViewTable} instance.
 * This class represents a specific implementation of a {@code Viewable} that returns
 * a {@code ViewTable} to be used for displaying data in a table format.
 */
public class ViewableTable extends ViewableResult {

    /**
     * Returns a new instance of {@code ViewTable}.
     *
     * @return a new {@code ViewTable} instance
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
