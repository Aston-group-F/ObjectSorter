package sorting.factory;

import sorting.algorithms.*;
import sorting.strategy.SortStrategy;
import model.Car;

public class SortStrategyFactory {

    public static SortStrategy<Car> create(int choice) {

        return switch (choice) {

            case 1 -> new BubbleSortStrategy<>();

            case 2 -> new SelectionSortStrategy<>();

            case 3 -> new InsertionSortStrategy<>();

            case 4 -> new QuickSortStrategy<>();

            case 5 -> new MergeSortStrategy<>();

            case 6 -> new HeapSortStrategy<>();

            default -> throw new IllegalArgumentException("Unknown sorting algorithm");

            // TODO delete error, cycle while ctobi console ne padala ???
        };
    }
}