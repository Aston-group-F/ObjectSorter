package console;

import java.util.Scanner;

import dataexporter.DataExporter;
import dataexporter.FileDataExporter;
import dataloader.DataLoader;
import dataloader.FileDataLoader;
import dataloader.InputDataLoader;
import dataloader.RandomDataLoader;
import model.*;
import sorting.comparator.CarComparedField;
import sorting.factory.SortStrategyFactory;
import utils.InputUtils;
/**
 * Represents the main console application responsible for interaction with the user.
 * Provides menu handling, loading, sorting, searching and exporting car collections.
 */
public class ConsoleApp {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleMenu menu = new ConsoleMenu();

    private final DataLoader inputLoader = new InputDataLoader(scanner);
    private final DataLoader randomLoader = new RandomDataLoader();
    private final DataLoader fileLoader = new FileDataLoader("src/main/resources/cars.txt");
    private final DataExporter dataExporter = new FileDataExporter("src/main/resources/exportedCars.txt");

    private final CarList cars = new CarList();
    /**
     * Starts the console application.
     *
     * @throws Exception if an unexpected error occurs during application execution
     */
    public void run() throws Exception {
        System.out.println("\nWelcome to Car Collection App");

        while (true) {
            menu.showMainMenu();
            var choice = InputUtils.readInt(scanner, menu.CHOOSE_OPTION);

            switch (choice) {
                case 1 -> {
                    menu.showFillingMethod();
                    var method = InputUtils.readIntInRange(scanner, menu.CHOOSE_OPTION, 4);
                    var n = InputUtils.readPositiveInt(scanner, menu.CARS_COUNT);

                    switch (method) {
                        case 1 -> {
                            cars.addAll(inputLoader.load(n));
                            menu.showAdded();
                        }
                        case 2 -> {
                            cars.addAll(randomLoader.load(n));
                            menu.showAdded();
                        }
                        case 3 -> {
                            cars.addAll(fileLoader.load(n));
                            menu.showAdded();
                        }
                    }
                }

                case 2 -> {
                    cars.forEach(System.out::println);
                }

                case 3 -> {
                    menu.showSortAlgorithms();
                    int sortAlgoChoice = InputUtils.readIntInRange(scanner, menu.CHOOSE_OPTION, 7);

                    menu.showUseConditional();
                    boolean useConditional = InputUtils.readBoolean(scanner, menu.CHOOSE_OPTION);

                    menu.showCarFields(useConditional);
                    int field = InputUtils.readIntInRange(scanner, menu.CHOOSE_OPTION, useConditional ? 3 : 4);

                    CarComparedField comparedField = null;
                    switch (field) {
                        case 1 -> comparedField = CarComparedField.POWER;
                        case 2 -> comparedField = CarComparedField.YEAR;
                        case 3 -> comparedField = CarComparedField.MODEL;
                    }
                    if (comparedField == null) {
                        System.err.println("Incorrect value entered");
                    } else {
                        SortStrategyFactory.create(sortAlgoChoice, useConditional).sort(cars, comparedField);
                        System.out.println("Sorted.");
                    }
                }

                case 4 -> {
                    scanner.nextLine();
                    System.out.println("\nEnter the car data for search:");
                    var car = inputLoader.load(1);
                    var count = cars.countOccurrences(car.get(0));
                    System.out.println("\nThis car is found in collection: " + count + " times");
                }

                case 5 -> {
                    if (cars.isEmpty()) {
                        System.err.println("Cars list is empty");
                    } else {
                        dataExporter.export(cars);
                    }
                }

                case 6 -> {
                    cars.clear();
                    System.out.println("The cars list has been cleared");
                }

                case 0 -> {
                    return;
                }
            }
        }
    }
}