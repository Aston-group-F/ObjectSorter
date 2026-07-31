package sorting.algorithms;

import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class InsertionSortStrategy<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {

        insertionSort(list, comparator);
    }

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