package sorting.algorithms;

import model.Car;
import org.junit.jupiter.api.Test;
import sorting.comparator.CarComparedField;
import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalSortStrategyTest {
    private final List<SortStrategy<Car>> strategies = List.of(
            new BubbleSortStrategy<>(),
            new SelectionSortStrategy<>(),
            new InsertionSortStrategy<>(),
            new QuickSortStrategy<>(),
            new MergeSortStrategy<>(),
            new HeapSortStrategy<>()
    );

    private final List<Car> sortedByYear = List.of(
            Car.builder().model("Mazda").year(1986).power(300).build(),
            Car.builder().model("Audi").year(2017).power(190).build(),
            Car.builder().model("Mercedes").year(2020).power(105).build(),
            Car.builder().model("Toyota").year(2019).power(150).build(),
            Car.builder().model("BMW").year(2022).power(251).build()
    );

    private final List<Car> sortedByPower = List.of(
            Car.builder().model("BMW").year(2022).power(251).build(),
            Car.builder().model("Toyota").year(2019).power(150).build(),
            Car.builder().model("Mercedes").year(2020).power(105).build(),
            Car.builder().model("Audi").year(2017).power(190).build(),
            Car.builder().model("Mazda").year(1986).power(300).build()
    );

    public static List<Car> getUnsortedCars() {
        return new ArrayList<>(List.of(
                Car.builder().model("BMW").year(2022).power(251).build(),
                Car.builder().model("Audi").year(2017).power(190).build(),
                Car.builder().model("Mercedes").year(2020).power(105).build(),
                Car.builder().model("Toyota").year(2019).power(150).build(),
                Car.builder().model("Mazda").year(1986).power(300).build()
        ));
    }

    @Test
    void sortByModelTest() {
           for (SortStrategy<Car> innerSortStrategy : strategies) {
               ConditionalSortStrategy<Car> conditional = new ConditionalSortStrategy<>(innerSortStrategy);
               List<Car> unsortedCars = getUnsortedCars();
               assertThrows(UnsupportedOperationException.class,
                       () -> conditional.sort(unsortedCars, CarComparedField.MODEL));
           }
    }

    @Test
    void sortByYearTest() {
        for (SortStrategy<Car> innerSortStrategy : strategies) {
            ConditionalSortStrategy<Car> conditional = new ConditionalSortStrategy<>(innerSortStrategy);
            List<Car> unsortedCars = getUnsortedCars();
            conditional.sort(unsortedCars, CarComparedField.YEAR);
            assertEquals(sortedByYear, unsortedCars);
        }
    }

    @Test
    void sortByPowerTest() {
        for (SortStrategy<Car> innerSortStrategy : strategies) {
            ConditionalSortStrategy<Car> conditional = new ConditionalSortStrategy<>(innerSortStrategy);
            List<Car> unsortedCars = getUnsortedCars();
            conditional.sort(unsortedCars, CarComparedField.POWER);
            assertEquals(sortedByPower, unsortedCars);
        }
    }
}