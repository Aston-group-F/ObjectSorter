package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ConditionalSortStrategy<T> implements SortStrategy<T> {
    private final SortStrategy<T> innerStrategy;

    public ConditionalSortStrategy(SortStrategy<T> innerStrategy) {
        this.innerStrategy = innerStrategy;
    }

    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        ToIntFunction<T> fieldMapper = field.getToIntFunction();
        if (fieldMapper == null) {
            throw new UnsupportedOperationException();
        }
        List<T> evenElements = list.stream()
                .filter(element -> fieldMapper.applyAsInt(element) % 2 == 0)
                .collect(Collectors.toList());
        if (!evenElements.isEmpty()) {
            innerStrategy.sort(evenElements, field);
        }

        int evenIndex = 0;
        for (int i = 0; i < list.size() && evenIndex < evenElements.size(); i++) {
            T current = list.get(i);
            if (fieldMapper.applyAsInt(current) % 2 == 0) {
                list.set(i, evenElements.get(evenIndex++));
            }
        }
    }
}
