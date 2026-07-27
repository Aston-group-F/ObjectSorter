package model;

import sorting.SortStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class CarList extends ArrayList<Car> {

    @Override
    public void sort(Comparator<? super Car> c) {
        throw new UnsupportedOperationException();
    }

    void sortByPower(SortStrategy sortStrategy) {
        sortStrategy.sortByPower(this);
    }

    void sortByYear(SortStrategy sortStrategy) {
        sortStrategy.sortByYear(this);
    }

    void sortByModel(SortStrategy sortStrategy) {
        sortStrategy.sortByModel(this);
    }
}
