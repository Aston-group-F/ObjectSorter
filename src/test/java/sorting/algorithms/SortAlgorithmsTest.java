package sorting.algorithms;

import model.Car;
import org.junit.jupiter.api.Test;
import sorting.comparator.CarComparedField;
import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SortStrategiesTest {

    private final List<SortStrategy<Car>> strategies = List.of(
            new BubbleSortStrategy<>(),
            new SelectionSortStrategy<>(),
            new InsertionSortStrategy<>(),
            new QuickSortStrategy<>(),
            new MergeSortStrategy<>(),
            new HeapSortStrategy<>()
    );


    private List<Car> getCars() {

        return new ArrayList<>(List.of(
                Car.builder().model("BMW").year(2020).power(250).build(),
                Car.builder().model("Audi").year(2018).power(190).build(),
                Car.builder().model("Mercedes").year(2022).power(300).build(),
                Car.builder().model("Toyota").year(2019).power(150).build()
        ));
    }


    @Test
    void sortByYearTest() {

        for (SortStrategy<Car> strategy : strategies) {

            List<Car> actual = getCars();

            List<Car> expected = new ArrayList<>(actual);
            expected.sort(CarComparedField.YEAR.getComparator());

            strategy.sort(actual, CarComparedField.YEAR);

            assertEquals(expected, actual);
        }
    }


    @Test
    void sortByPowerTest() {

        for (SortStrategy<Car> strategy : strategies) {

            List<Car> actual = getCars();

            List<Car> expected = new ArrayList<>(actual);
            expected.sort(CarComparedField.POWER.getComparator());

            strategy.sort(actual, CarComparedField.POWER);

            assertEquals(expected, actual);
        }
    }


    @Test
    void sortByModelTest() {

        for (SortStrategy<Car> strategy : strategies) {

            List<Car> actual = getCars();

            List<Car> expected = new ArrayList<>(actual);
            expected.sort(CarComparedField.MODEL.getComparator());

            strategy.sort(actual, CarComparedField.MODEL);

            assertEquals(expected, actual);
        }
    }
}