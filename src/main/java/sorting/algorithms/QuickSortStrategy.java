package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;
/**
 * Implements the Quick Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class QuickSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Quick Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        quickSort(list, 0, list.size() - 1, field.getComparator());
    }
    /**
     * Recursively sorts the specified range of the collection.
     *
     * @param list the collection to sort
     * @param low the starting index of the range
     * @param high the ending index of the range
     * @param comparator the comparator used to compare elements
     */
    private void quickSort(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            var pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }
    /**
     * Partitions the specified range around a pivot element.
     *
     * @param list the collection to partition
     * @param low the starting index of the range
     * @param high the ending index of the range
     * @param comparator the comparator used to compare elements
     * @return the final position of the pivot element
     */
    private int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        var pivot = list.get(high);
        var i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                var temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        var temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
