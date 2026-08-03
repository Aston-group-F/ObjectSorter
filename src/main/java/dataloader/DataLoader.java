package dataloader;

import model.CarList;

public interface DataLoader {
    /**
     * Loads a collection of Cars in a certain way
     *
     * @return Collection of Cars
     */
    CarList load(int carsCount);

}
