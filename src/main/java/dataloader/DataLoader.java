package dataloader;

import model.CarList;

/**
 * Defines a contract for loading a collection of {@link model.Car} objects.
 * <p>
 * Implementations may load data from different sources, such as user input,
 * files, or randomly generated values.
 */
public interface DataLoader {

    /**
     * Loads the specified number of cars.
     *
     * @param carsCount the number of cars to load
     * @return a {@link CarList} containing the loaded cars
     */
    CarList load(int carsCount);
}
