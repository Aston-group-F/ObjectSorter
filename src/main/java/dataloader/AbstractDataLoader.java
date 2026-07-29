package dataloader;

import model.Car;
import model.CarList;

import java.util.List;

abstract class AbstractDataLoader implements DataLoader {
    public CarList load(int carsCount) {
        if(carsCount < 1) {
            throw  new IllegalArgumentException("The length of the collection of cars must be greater than 0");
        }
        return loadData(carsCount);
    }

    protected abstract CarList loadData(int carsCount);
}
