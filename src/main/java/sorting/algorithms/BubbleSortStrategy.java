package sorting.algorithms;

import java.util.Comparator;
import java.util.List;
import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;
/**
 * Implements the Bubble Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class BubbleSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Bubble Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        bubbleSort(list, field.getComparator());
    }
    /**
     * Sorts the collection using the specified comparator.
     *
     * @param list the collection to sort
     * @param comparator the comparator used to compare elements
     */
    private void bubbleSort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            var isSwap = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}