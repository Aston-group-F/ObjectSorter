package model;

import sorting.comparator.CarComparedField;
import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class CarList extends ArrayList<Car> {

    public void sort(SortStrategy<Car> strategy, CarComparedField carField) {
        strategy.sort(this, carField);
    }
}
