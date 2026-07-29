package dataloader;

import org.junit.jupiter.api.Test;

import model.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileDataLoaderTest {
    private static final String RESOURCES_PATH = "src/test/resources/";

    @Test
    void fileDataLoaderInitializationTest(){
        String invalidFilePath = "";
        String validFilePath = "cars.txt";

        assertThrows(IllegalArgumentException.class, () -> new FileDataLoader(invalidFilePath));

        assertThrows(IllegalArgumentException.class, () -> new FileDataLoader(null));

        assertDoesNotThrow(() -> new FileDataLoader(validFilePath));
    }

    @Test
    void validDataTest() {
        String filePath = RESOURCES_PATH + "valid_cars.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        List<Car> cars = dataLoader.loadData(5);

        assertNotNull(cars);
        assertEquals(5, cars.size());

        Car firstCar = cars.get(0);
        assertEquals("Toyota Camry", firstCar.getModel());
        assertEquals(2020, firstCar.getYear());
        assertEquals(203, firstCar.getPower());

        Car lastCar = cars.get(cars.size() - 1);
        assertEquals("Honda Accord", lastCar.getModel());
        assertEquals(2022, lastCar.getYear());
        assertEquals(192, lastCar.getPower());
    }

    @Test
    void invalidCarsCountTest() {
        String filePath = RESOURCES_PATH + "valid_cars.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        List<Car> cars = dataLoader.loadData(3);

        assertNotNull(cars);
        assertEquals(3, cars.size());
        Car lastCar = cars.get(cars.size() - 1);
        assertEquals("Mercedes E-Class", lastCar.getModel());
        assertEquals(2021, lastCar.getYear());
        assertEquals(255, lastCar.getPower());

        assertThrows(IllegalArgumentException.class, () -> dataLoader.loadData(7));
    }

    @Test
    void dataWithEmptyLinesTest() {
        String filePath = RESOURCES_PATH + "valid_cars_with_empty_lines.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        List<Car> cars = dataLoader.loadData(3);

        assertEquals(3, cars.size());
    }

    @Test
    void invalidDataTest() {
        String filePath = RESOURCES_PATH + "invalid_cars.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        List<Car> cars = dataLoader.loadData(2);

        assertEquals(2, cars.size());
        assertEquals("Toyota Camry", cars.get(0).getModel());
        assertEquals("Audi A4", cars.get(1).getModel());
    }

    @Test
    void emptyFileTest() {
        String filePath = RESOURCES_PATH + "empty_file.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        assertThrows(RuntimeException.class, () -> dataLoader.loadData(1));
    }

    @Test
    void invalidFileTest() {
        String filePath = RESOURCES_PATH + "invalid_file.txt";
        FileDataLoader dataLoader = new FileDataLoader(filePath);

        assertThrows(RuntimeException.class, () -> dataLoader.loadData(5));
    }
}