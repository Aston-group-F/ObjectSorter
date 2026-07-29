package utils;

import java.util.Scanner;

public final class InputUtils {

    private InputUtils() { }

    public static int readPositiveInt(Scanner scanner, String message) {

        while (true) {

            int value = readInt(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println("The number must be greater than 0.");
        }
    }

    public static int readInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;
            }

            System.out.println("Please enter an integer.");
            scanner.nextLine();
        }
    }

    public static String readString(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String model = scanner.nextLine().trim();

            if (!model.isEmpty()) {
                return model;
            }

            System.out.println("Model cannot be empty.");
        }
    }
}