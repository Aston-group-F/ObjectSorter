package sorting.comparator;

import model.Car;

import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * Represents the available fields that can be used
 * to compare and sort {@link Car} objects.
 */
public enum CarComparedField implements ComparedField<Car> {
    MODEL {
        @Override
        public Comparator<Car> getComparator() {
            return Comparator.comparing(Car::getModel);
        }

        @Override
        public ToIntFunction<Car> getToIntFunction() {
            return null;
        }
    },
    YEAR {
        @Override
        public Comparator<Car> getComparator() {
            return Comparator.comparingInt(Car::getYear);
        }

        @Override
        public ToIntFunction<Car> getToIntFunction() {
            return Car::getYear;
        }
    },
    POWER {
        @Override
        public Comparator<Car> getComparator() {
            return Comparator.comparingInt(Car::getPower);
        }

        @Override
        public ToIntFunction<Car> getToIntFunction() {
            return Car::getPower;
        }
    };
}
