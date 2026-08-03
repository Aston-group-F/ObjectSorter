package sorting.strategy;

import sorting.comparator.ComparedField;

import java.util.List;

public interface SortStrategy<T> {
    void sort(List<T> list, ComparedField<T> field);
}
