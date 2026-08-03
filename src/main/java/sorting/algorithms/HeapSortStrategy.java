package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class HeapSortStrategy<T> implements SortStrategy<T> {
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        heapSort(list, field.getComparator());
    }

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