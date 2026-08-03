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
            String inputString = scanner.nextLine().trim();
            if (!inputString.isEmpty()) {
                return inputString;
            }
            System.out.println("Input string cannot be empty.");
        }
    }

    public static int readIntInRange(Scanner scanner, String message, int upperBound) {
        while (true) {
            int value = readInt(scanner, message);
            if (value > 0 && value < upperBound) {
                return value;
            }
            System.out.println("The number must be in range [1;" + (upperBound - 1) + "]");
        }
    }

    public static boolean readBoolean(Scanner scanner, String message) {
        while (true) {
            String inputString = readString(scanner, message).toLowerCase();
            if (inputString.equals("y") || inputString.equals("yes")) {
                return true;
            } else if (inputString.equals("n") || inputString.equals("no")) {
                return false;
            }
            System.out.println("The value Y/Yes or N/No must be entered.");
        }
    }
}