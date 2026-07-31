package model;

import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class CarList extends ArrayList<Car> {

    public void sort(SortStrategy<Car> strategy, Comparator<Car> comparator) {

        strategy.sort(this, comparator);
    }
}
