package sorting.strategy;

import sorting.comparator.ComparedField;

import java.util.List;
/**
 * Defines a sorting strategy for a collection of objects.
 *
 * @param <T> the type of elements to be sorted
 */
public interface SortStrategy<T> {
    /**
     * Sorts the specified collection using the selected comparison field.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    void sort(List<T> list, ComparedField<T> field);
}
