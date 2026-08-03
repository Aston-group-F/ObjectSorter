package dataloader;

import model.CarList;

public interface DataLoader {
    CarList load(int carsCount);
}
