package dataloader;

import model.Car;

import java.util.List;

abstract class AbstractDataLoader implements IDataLoader{
    public List<Car> load(int carsCount) {
        if(carsCount < 1) {
            throw  new IllegalArgumentException("The length of the collection of cars must be greater than 0");
        }
        return loadData(carsCount);
    }

    protected abstract List<Car> loadData(int carsCount);
}
