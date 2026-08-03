package sorting.factory;

import sorting.algorithms.*;
import sorting.strategy.SortStrategy;
import model.Car;

public class SortStrategyFactory {

    private static SortStrategy<Car> createSortStrategy(int choice) {
        return switch (choice) {
            case 1 -> new BubbleSortStrategy<>();
            case 2 -> new SelectionSortStrategy<>();
            case 3 -> new InsertionSortStrategy<>();
            case 4 -> new QuickSortStrategy<>();
            case 5 -> new MergeSortStrategy<>();
            case 6 -> new HeapSortStrategy<>();
            default -> throw new IllegalArgumentException("Unknown sorting algorithm");
        };
    }

    public static SortStrategy<Car> create(int choice, boolean useConditional) {
        SortStrategy<Car> strategy = createSortStrategy(choice);
        if (useConditional) {
            strategy = new ConditionalSortStrategy<>(strategy);
        }
        return strategy;
    }
}