package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;
/**
 * Implements the Selection Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class SelectionSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Selection Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        selectionSort(list, field.getComparator());
    }
    /**
     * Sorts the collection using the specified comparator.
     *
     * @param list the collection to sort
     * @param comparator the comparator used to compare elements
     */
    private void selectionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            var minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}