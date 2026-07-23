package dataloader;

import model.Car;

import java.util.List;

public interface IDataLoader {
    /**
     * @return Collection of Cars
     */
    List<Car> load(int carsCount);

}
