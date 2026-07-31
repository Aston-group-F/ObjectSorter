package sorting.comparator;

import model.Car;
import java.util.Comparator;

public class CarComparators {

    public static Comparator<Car> byModel() {

        return Comparator.comparing(Car::getModel);
    }

    public static Comparator<Car> byPower() {

        return Comparator.comparingInt(Car::getPower);
    }

    public static Comparator<Car> byYear() {

        return Comparator.comparingInt(Car::getYear);
    }
}