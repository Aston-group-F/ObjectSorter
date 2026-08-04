package sorting.algorithms;

import sorting.comparator.ComparedField;
import sorting.strategy.SortStrategy;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
/**
 * Sorts only the elements that satisfy a specific condition.
 * <p>
 * This implementation delegates the actual sorting to another
 * {@link SortStrategy} and applies it only to elements whose
 * selected numeric field contains an even value.
 *
 * @param <T> the type of elements to be sorted
 */
public class ConditionalSortStrategy<T> implements SortStrategy<T> {
    /**
     * The sorting strategy used to sort the selected elements.
     */
    private final SortStrategy<T> innerStrategy;
    /**
     * Creates a new conditional sorting strategy.
     *
     * @param innerStrategy the sorting strategy used for the selected elements
     */
    public ConditionalSortStrategy(SortStrategy<T> innerStrategy) {
        this.innerStrategy = innerStrategy;
    }
    /**
     * Sorts only the elements whose selected field contains an even value.
     *
     * @param list the collection to sort
     * @param field the field used for comparison
     * @throws UnsupportedOperationException if the selected field is not numeric
     */
    @Override
    public void sort(List<T> list, ComparedField<T> field) {
        ToIntFunction<T> fieldMapper = field.getToIntFunction();
        if (fieldMapper == null) {
            throw new UnsupportedOperationException(
                "Conditional sorting is only available for numeric fields");
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
