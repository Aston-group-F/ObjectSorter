package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;
/**
 * Implements the Heap Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class HeapSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Heap Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        heapSort(list, field.getComparator());
    }
    /**
     * Sorts the collection using the specified comparator.
     *
     * @param list the collection to sort
     * @param comparator the comparator used to compare elements
     */
    private void heapSort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(list, size, i, comparator);
        }

        for (int i = size - 1; i > 0; i--) {
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            heapify(list, i, 0, comparator);
        }
    }
    /**
     * Restores the heap property for the specified subtree.
     *
     * @param list the collection representing the heap
     * @param size the current heap size
     * @param index the index of the subtree root
     * @param comparator the comparator used to compare elements
     */
    private void heapify(List<T> list, int size, int index, Comparator<T> comparator) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && comparator.compare(list.get(left), list.get(largest)) > 0) {
            largest = left;
        }

        if (right < size && comparator.compare(list.get(right), list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != index) {
            T temp = list.get(index);
            list.set(index, list.get(largest));
            list.set(largest, temp);
            heapify(list, size, largest, comparator);
        }
    }
}