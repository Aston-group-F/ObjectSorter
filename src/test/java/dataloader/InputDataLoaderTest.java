package dataloader;

import model.Car;
import model.CarList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputDataLoaderTest {

    @Test
    void validInputTest() {

        String input = """
                Toyota
                200
                2020
                """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(1);

        assertNotNull(cars);
        assertEquals(1, cars.size());

        Car car = cars.get(0);

        assertEquals("Toyota", car.getModel());
        assertEquals(200, car.getPower());
        assertEquals(2020, car.getYear());
    }

    @Test
    void validMultipleCarsTest() {

        String input = """
            Toyota
            200
            2020
            BMW
            300
            2021
            """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(2);

        assertEquals(2, cars.size());

        assertEquals("Toyota", cars.get(0).getModel());
        assertEquals("BMW", cars.get(1).getModel());

        assertEquals(200, cars.get(0).getPower());
        assertEquals(300, cars.get(1).getPower());
    }

    @Test
    void invalidCarsCountTest() {

        Scanner scanner = new Scanner("");

        DataLoader loader = new InputDataLoader(scanner);

        assertThrows(IllegalArgumentException.class,
                () -> loader.load(0));
    }

    @Test
    void emptyModelTest() {

        String input = """

            Toyota
            200
            2020
            """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(1);

        assertNotNull(cars);
        assertEquals(1, cars.size());

        Car car = cars.get(0);

        assertEquals("Toyota", car.getModel());
        assertEquals(200, car.getPower());
        assertEquals(2020, car.getYear());
    }

    @Test
    void invalidPowerInputTest() {

        String input = """
            Toyota
            abc
            200
            2020
            """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(1);

        assertNotNull(cars);
        assertEquals(1, cars.size());

        Car car = cars.get(0);

        assertEquals("Toyota", car.getModel());
        assertEquals(200, car.getPower());
        assertEquals(2020, car.getYear());
    }

    @Test
    void invalidPowerInputTest() {

        String input = """
            Toyota
            abc
            200
            2020
            """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(1);

        assertNotNull(cars);
        assertEquals(1, cars.size());

        Car car = cars.get(0);

        assertEquals("Toyota", car.getModel());
        assertEquals(200, car.getPower());
        assertEquals(2020, car.getYear());
    }

    @Test
    void invalidYearInputTest() {

        String input = """
            Toyota
            200
            abc
            2020
            """;

        Scanner scanner = new Scanner(input);

        DataLoader loader = new InputDataLoader(scanner);

        CarList cars = loader.load(1);

        assertNotNull(cars);
        assertEquals(1, cars.size());

        Car car = cars.get(0);

        assertEquals("Toyota", car.getModel());
        assertEquals(200, car.getPower());
        assertEquals(2020, car.getYear());
    }
}