package dataloader;

import model.Car;
import model.CarList;

import java.util.List;

/**
 * Base implementation of the {@link DataLoader} interface.
 * <p>
 * Provides common validation for the number of cars to load
 * and delegates the actual loading process to subclasses.
 */
abstract class AbstractDataLoader implements DataLoader {

    /**
     * Validates the requested number of cars and loads them.
     *
     * @param carsCount the number of cars to load
     * @return a {@link CarList} containing the loaded cars
     * @throws IllegalArgumentException if {@code carsCount} is less than 1
     */
    public CarList load(int carsCount) {
        if(carsCount < 1) {
            throw  new IllegalArgumentException("The length of the collection of cars must be "
                + "greater than 0");
        }
        return loadData(carsCount);
    }

    /**
     * Loads the specified number of cars.
     * <p>
     * The actual loading mechanism is defined by subclasses.
     *
     * @param carsCount the number of cars to load
     * @return a {@link CarList} containing the loaded cars
     */
    protected abstract CarList loadData(int carsCount);
}
