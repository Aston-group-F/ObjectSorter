package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class QuickSortStrategy<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        quickSort(list, 0, list.size() - 1, field.getComparator());
    }

    private void quickSort(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            var pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

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
