package dataloader;

import constants.CarConstants;

import model.Car;
import model.CarList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Loads randomly generated car data.
 * <p>
 * Each generated car has a random model, power, and production year
 * within the valid ranges defined by {@link CarConstants}.
 */
public class RandomDataLoader extends AbstractDataLoader{

    /**
     * Predefined list of car models used for random generation.
     */
    private static final List<String> CARS_MODELS_LIST = List.of( "Toyota Corolla", "Ford F-Series",
            "Toyota RAV4", "Honda CR-V", "Toyota Camry", "Hyundai Solaris", "Chevrolet Niva",
            "Honda Civic", "Volkswagen Tiguan", "Tesla Model Y", "Tesla Model 3", "Honda Accord",
            "Nissan Qashqai", "Kia Sportage", "Volkswagen Golf", "Nissan Sentra", "Kia Rio", "Mazda CX-5",
            "Subaru Forester", "Ford Explorer", "Mercedes-Benz G-Class", "BMW 3 Series", "Mercedes-Benz C-Class",
            "Audi A4", "Ford Escape", "Volkswagen Polo", "Renault Logan", "MINI Cooper" );

    /**
     * Generates the specified number of random cars.
     *
     * @param carsCount the number of cars to generate
     * @return a {@link CarList} containing randomly generated cars
     */
    @Override
    protected CarList loadData(int carsCount) {
        return Stream.generate(this::generateCar)
                .limit(carsCount)
                .collect(Collectors.toCollection(CarList::new));
    }

    /**
     * Generates a single random car.
     *
     * @return a randomly generated {@link Car}
     */
    private Car generateCar() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        return Car.builder()
                .model(CARS_MODELS_LIST.get(rand.nextInt(CARS_MODELS_LIST.size())))
                .power(rand.nextInt(CarConstants.MIN_VALID_POWER, CarConstants.MAX_VALID_POWER + 1))
                .year(rand.nextInt(CarConstants.FIRST_CAR_YEAR, CarConstants.CURRENT_YEAR + 1))
                .build();
    }
}
