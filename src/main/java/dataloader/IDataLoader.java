package dataloader;

import model.Car;

import java.util.List;

public interface IDataLoader {
    /**
     * Loads a collection of Cars in a certain way
     *
     * @return Collection of Cars
     */
    List<Car> load(int carsCount);

}
