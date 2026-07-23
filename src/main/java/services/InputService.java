package services;

import model.Car;
import java.util.Scanner;

public class InputService {

    private static final Scanner scanner = new Scanner(System.in);

    public static Car inputCar() {

        while (true) {

            try {

                String model = readModel();
                int power = readInt("Power: ");
                int year = readInt("Year: ");

                return Car.builder().model(model).power(power).year(year).build();

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again.");
            }
        }
    }


    private static String readModel() {

        while (true) {

            System.out.print("Model: ");

            String model = scanner.nextLine().trim();

            if (!model.isEmpty()) {
                return model;
            }

            System.out.println("Model cannot be empty.");
        }
    }


    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;
            }

            System.out.println("Please enter a integer.");
            scanner.nextLine();
        }
    }
}