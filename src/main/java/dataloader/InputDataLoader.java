package dataloader;

import model.Car;
import model.CarList;
import utils.InputUtils;

import java.util.Scanner;

public class InputDataLoader extends AbstractDataLoader {

    private final Scanner scanner;

    public InputDataLoader(Scanner scanner) {

        this.scanner = scanner;
    }

    @Override
    protected CarList loadData(int carsCount) {

        CarList cars = new CarList();

        for (int i = 0; i < carsCount; i++) {

            System.out.println("\nCar #" + (i + 1));
            cars.add(inputCar());
        }

        return cars;
    }

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