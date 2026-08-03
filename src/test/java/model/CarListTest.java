package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.algorithms.BubbleSortStrategy;
import sorting.comparator.CarComparedField;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private final CarList carList = new CarList();

    private final List<Car> sortedByModel = List.of(
            Car.builder().model("Audi").year(2018).power(190).build(),
            Car.builder().model("Audi").year(2018).power(190).build(),
            Car.builder().model("Audi").year(2018).power(190).build(),
            Car.builder().model("BMW").year(2020).power(250).build(),
            Car.builder().model("Mercedes").year(2022).power(300).build(),
            Car.builder().model("Toyota").year(2019).power(150).build()
    );

    @BeforeEach
    public void setup() {
        carList.add(Car.builder().model("Audi").year(2018).power(190).build());
        carList.add(Car.builder().model("Toyota").year(2019).power(150).build());
        carList.add(Car.builder().model("Audi").year(2018).power(190).build());
        carList.add(Car.builder().model("BMW").year(2020).power(250).build());
        carList.add(Car.builder().model("Audi").year(2018).power(190).build());
        carList.add(Car.builder().model("Mercedes").year(2022).power(300).build());
    }

    @Test
    public void sortTest() {
        carList.sort(new BubbleSortStrategy<>(), CarComparedField.MODEL);
        assertEquals(sortedByModel, carList);
    }

    @Test
    public void countOccurrencesTest() throws ExecutionException, InterruptedException {
        assertEquals(3, carList.countOccurrences(Car.builder().model("Audi").year(2018).power(190).build()));
        assertEquals(1, carList.countOccurrences(Car.builder().model("Toyota").year(2019).power(150).build()));
        assertEquals(0, carList.countOccurrences(Car.builder().model("Totoya").year(2019).power(150).build()));
    }
}