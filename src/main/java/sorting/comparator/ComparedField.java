package sorting.comparator;

import java.util.Comparator;
import java.util.function.ToIntFunction;
/**
 * Defines a comparison strategy for a specific field of an object.
 *
 * @param <T> the type of objects being compared
 */
public interface ComparedField<T> {
    /**
     * Returns a comparator for the selected field.
     *
     * @return a comparator for comparing objects
     */
    Comparator<T> getComparator();
    /**
     * Returns a function that extracts the field value as an integer.
     *
     * @return a function that extracts an integer value from an object
     */
    ToIntFunction<T> getToIntFunction();
}
