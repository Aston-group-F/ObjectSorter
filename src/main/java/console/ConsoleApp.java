package console;

import java.util.Scanner;
import dataloader.DataLoader;
import dataloader.FileDataLoader;
import dataloader.InputDataLoader;
import dataloader.RandomDataLoader;
import model.*;
import sorting.comparator.CarComparators;
import sorting.factory.SortStrategyFactory;
import sorting.strategy.SortStrategy;
import utils.InputUtils;

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleMenu menu = new ConsoleMenu();

    private final DataLoader inputLoader = new InputDataLoader(scanner);
    private final DataLoader randomLoader = new RandomDataLoader();
    private final DataLoader fileLoader = new FileDataLoader("src/main/resources/cars.txt");

    private CarList cars = new CarList();

    public void run() throws Exception {

        while (true) {

            menu.showMainMenu();

            var choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {

                    cars.clear(); // TODO delete at final (now for testing)

                    var n = InputUtils.readPositiveInt(scanner, "Cars count: ");

                    cars = inputLoader.load(n);
                }

                case 2 -> {

                    cars.clear(); // TODO delete at final (now for testing)

                    var n = InputUtils.readPositiveInt(scanner, "Cars count: "); // TODO show size of random list

                    cars = randomLoader.load(n);
                }

                case 3 -> {

                    cars.clear(); // TODO delete at final (now for testing)

                    var n = InputUtils.readPositiveInt(scanner, "Cars count: ");

                    cars = fileLoader.load(n);
                }

                case 4 -> {

                    cars.forEach(System.out::println);
                }

                case 5 -> {

                    menu.showSortAlgorithms();

                    SortStrategy<Car> strategy = SortStrategyFactory.create(scanner.nextInt());

                    menu.showCarFields();

                    var field = scanner.nextInt(); // TODO add check number at 1-3 to InputUtils ???

                    switch (field) {

                        case 1 -> cars.sort(
                                strategy,
                                CarComparators.byModel()
                        );

                        case 2 -> cars.sort(
                                strategy,
                                CarComparators.byPower()
                        );

                        case 3 -> cars.sort(
                                strategy,
                                CarComparators.byYear()
                        );

                        default -> System.out.println("Wrong field");
                    }

                    System.out.println("Sorted.");
                }

                case 0 -> {

                    return;
                }
            }
        }
    }
}