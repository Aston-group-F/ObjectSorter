package sorting.algorithms;

import sorting.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class ConditionalSortStrategy<T> implements SortStrategy<T> {

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {

        conditionalSort();
    }

    private void conditionalSort() {

        // TODO dop zadanie chetnie ne chetnie
    }
}
