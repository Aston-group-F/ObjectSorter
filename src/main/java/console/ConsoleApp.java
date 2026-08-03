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

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleMenu menu = new ConsoleMenu();

    private final DataLoader inputLoader = new InputDataLoader(scanner);
    private final DataLoader randomLoader = new RandomDataLoader();
    private final DataLoader fileLoader = new FileDataLoader("src/main/resources/cars.txt");
    private final DataExporter dataExporter = new FileDataExporter("src/main/resources/exportedCars.txt");

    private final CarList cars = new CarList();

    public void run() throws Exception {

        while (true) {

            menu.showMainMenu();

            var choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {

                    var n = InputUtils.readPositiveInt(scanner, ConsoleMenu.CARS_COUNT);
                    cars.addAll(inputLoader.load(n));
                    menu.showAdded();
                }

                case 2 -> {

                    var n = InputUtils.readPositiveInt(scanner, ConsoleMenu.CARS_COUNT);
                    cars.addAll(randomLoader.load(n));
                    menu.showAdded();
                }

                case 3 -> {

                    var n = InputUtils.readPositiveInt(scanner, ConsoleMenu.CARS_COUNT);
                    cars.addAll(fileLoader.load(n));
                }

                case 4 -> {

                    cars.forEach(System.out::println);
                }

                case 5 -> {
                    menu.showSortAlgorithms();
                    int sortAlgoChoice = InputUtils.readIntInRange(scanner, ConsoleMenu.CHOOSE_OPTION, 7);

                    menu.showUseConditional();
                    boolean useConditional = InputUtils.readBoolean(scanner, ConsoleMenu.CHOOSE_OPTION);

                    menu.showCarFields(useConditional);
                    int field = InputUtils.readIntInRange(scanner, ConsoleMenu.CHOOSE_OPTION, useConditional ? 3 : 4);

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

                case 6 -> {

                    scanner.nextLine();

                    System.out.println("\nEnter the car data for search:");

                    var car = inputLoader.load(1);
                    var count = cars.countOccurrences(car.get(0));

                    System.out.println("\nThis car is found in collection: " + count + " times");
                }

                case 7 -> {

                    if (cars.isEmpty()) {

                        System.err.println("Cars list is empty");
                    }

                    dataExporter.export(cars);
                }

                case 0 -> {

                    return;
                }
            }
        }
    }
}