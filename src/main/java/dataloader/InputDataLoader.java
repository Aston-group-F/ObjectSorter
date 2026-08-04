package dataloader;

import model.Car;
import model.CarList;
import utils.InputUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Loads car data entered manually by the user.
 * <p>
 * The user is prompted to enter the model, power, and year
 * for each car. Invalid input is rejected until valid data
 * is provided.
 */
public class InputDataLoader extends AbstractDataLoader {

    /**
     * Scanner used to read user input.
     */
    private final Scanner scanner;

    /**
     * Creates a new data loader that reads car data from the console.
     *
     * @param scanner the scanner used to read user input
     */
    public InputDataLoader(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Loads the specified number of cars from user input.
     *
     * @param carsCount the number of cars to load
     * @return a {@link CarList} containing the entered cars
     */
    @Override
    protected CarList loadData(int carsCount) {
        CarList cars = new CarList();

        IntStream.range(0, carsCount).forEach(i -> {
            System.out.println("\nCar #" + (i + 1));
            cars.add(inputCar());
        });

        return cars;
    }

    /**
     * Reads and validates data for a single car.
     * <p>
     * If invalid input is provided, the user is informed about
     * the error and prompted to enter the data again.
     *
     * @return a validated {@link Car} instance
     */
    private Car inputCar() {
        while (true) {
            try {
                String model = InputUtils.readString(scanner, "Model: ");
                int power = InputUtils.readInt(scanner, "Power: ");
                int year = InputUtils.readInt(scanner,"Year: ");

                return Car.builder()
                        .model(model)
                        .power(power)
                        .year(year)
                        .build();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again.");
            }
        }
    }
}