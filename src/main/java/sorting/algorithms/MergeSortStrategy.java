package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Implements the Merge Sort algorithm.
 * <p>
 * Sorts a collection using the comparison field provided
 * by the specified {@link ComparedField}.
 *
 * @param <T> the type of elements to be sorted
 */
public class MergeSortStrategy<T> implements SortStrategy<T> {
    /**
     * Sorts the specified collection using the Merge Sort algorithm.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        mergeSort(list, 0, list.size() - 1, field.getComparator());
    }

    /**
     * Recursively divides the collection into smaller parts
     * and sorts them using the Merge Sort algorithm.
     *
     * @param list the collection to sort
     * @param left the left boundary of the current range
     * @param right the right boundary of the current range
     * @param comparator the comparator used to compare elements
     */
    private void mergeSort(List<T> list, int left, int right, Comparator<T> comparator) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(list, left, middle, comparator);
            mergeSort(list, middle + 1, right, comparator);

            merge(list, left, middle, right, comparator);
        }
    }

    /**
     * Merges two sorted parts of the collection into a single sorted range.
     *
     * @param list the collection being sorted
     * @param left the left boundary of the first range
     * @param middle the ending index of the first range
     * @param right the right boundary of the second range
     * @param comparator the comparator used to compare elements
     */
    private void merge(List<T> list, int left, int middle, int right, Comparator<T> comparator) {
        List<T> leftList = new ArrayList<>(list.subList(left, middle + 1));
        List<T> rightList = new ArrayList<>(list.subList(middle + 1, right + 1));

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftList.size() && j < rightList.size()) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) <= 0) {
                list.set(k++, leftList.get(i++));
            }
            else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }
}