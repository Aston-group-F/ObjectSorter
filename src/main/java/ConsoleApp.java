import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataloader.DataLoader;
import dataloader.InputDataLoader;
import dataloader.RandomDataLoader;
import model.Car;
import utils.InputUtils;

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);

    private final DataLoader inputDataLoader = new InputDataLoader(scanner);
    private final DataLoader randomLoader = new RandomDataLoader();

    private List<Car> cars = new ArrayList<>();

    public void run() throws Exception {

        while (true) {

            System.out.println();
            System.out.println("1. Manual");
            System.out.println("2. Random");
            System.out.println("3. File");
            System.out.println("4. Print");
            System.out.println("5. Sort");
            System.out.println("0. Exit");

            var choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {

                    cars.clear(); // TODO delete at final (now for testing)

                    var n = InputUtils.readPositiveInt(scanner, "Cars count: ");

                    cars = inputDataLoader.load(n);
                }

                case 2 -> {

                    cars.clear(); // TODO delete at final (now for testing)

                    var n = InputUtils.readPositiveInt(scanner, "Cars count: "); // TODO show size of random list

                    cars = randomLoader.load(n);
                }

                case 3 -> {

                    // TODO
                    //cars = load from "cars.txt"
                }

                case 4 -> {

                    cars.forEach(System.out::println);
                }

                case 5 -> {

                    System.out.println("1.Model");
                    System.out.println("2.Power");
                    System.out.println("3.Year");

                    var field = scanner.nextInt();

                    switch (field) {

                        // TODO
                        //case 1 -> sort by Model

                        //case 2 -> sort by Power

                        //case 3 -> sort by Year
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