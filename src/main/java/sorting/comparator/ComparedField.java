package sorting.comparator;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public interface ComparedField<T> {
    Comparator<T> getComparator();
    ToIntFunction<T> getToIntFunction();
}
