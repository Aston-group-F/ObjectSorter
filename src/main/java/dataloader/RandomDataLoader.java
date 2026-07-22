package dataloader;

import constants.CarConstants;

import model.Car;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDataLoader extends AbstractDataLoader{

    private static final List<String> CARS_MODELS_LIST = List.of( "Toyota Corolla", "Ford F-Series",
            "Toyota RAV4", "Honda CR-V", "Toyota Camry", "Hyundai Solaris", "Chevrolet Niva",
            "Honda Civic", "Volkswagen Tiguan", "Tesla Model Y", "Tesla Model 3", "Honda Accord",
            "Nissan Qashqai", "Kia Sportage", "Volkswagen Golf", "Nissan Sentra", "Kia Rio", "Mazda CX-5",
            "Subaru Forester", "Ford Explorer", "Mercedes-Benz G-Class", "BMW 3 Series", "Mercedes-Benz C-Class",
            "Audi A4", "Ford Escape", "Volkswagen Polo", "Renault Logan", "MINI Cooper" );

    @Override
    protected List<Car> loadData(int carsCount) {
        List<Car> carsList = new ArrayList<>(carsCount);
        for (int i = 0; i < carsCount; i++) {
            carsList.add(generateCar());
        }
        return carsList;
    }

    private Car generateCar() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        return Car.builder()
                .model(CARS_MODELS_LIST.get(rand.nextInt(CARS_MODELS_LIST.size())))
                .power(rand.nextInt(CarConstants.MIN_VALID_POWER, CarConstants.MAX_VALID_POWER + 1))
                .year(rand.nextInt(CarConstants.FIRST_CAR_YEAR, LocalDateTime.now().getYear() + 1))
                .build();
    }
}
