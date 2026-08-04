package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;
/**
 * Implements the Insertion Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class InsertionSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Insertion Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        insertionSort(list, field.getComparator());
    }
    /**
     * Sorts the collection using the specified comparator.
     *
     * @param list the collection to sort
     * @param comparator the comparator used to compare elements
     */
    private void insertionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), current) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }
}