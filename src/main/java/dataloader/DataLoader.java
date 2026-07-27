package dataloader;

import model.Car;
import model.CarList;

import java.util.List;

public interface DataLoader {
    /**
     * Loads a collection of Cars in a certain way
     *
     * @return Collection of Cars
     */
    CarList load(int carsCount);

}
