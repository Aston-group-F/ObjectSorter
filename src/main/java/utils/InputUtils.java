package utils;

import java.util.Scanner;

/**
 * Utility class for reading and validating user input.
 */
public final class InputUtils {

    /**
     * * Prevents instantiation of the utility class.
     */
    private InputUtils() { }

    /**
     * Reads a positive integer from the user.
     *
     * @param scanner scanner used to read input
     * @param message prompt displayed to the user
     * @return positive integer entered by the user
     */
    public static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            int value = readInt(scanner, message);
            if (value > 0) {
                return value;
            }
            System.out.println("The number must be greater than 0.");
        }
    }

    /**
     * Reads an integer from the user.
     * Repeats the request until a valid integer is entered.
     *
     * @param scanner scanner used to read input
     * @param message prompt displayed to the user
     * @return entered integer
     */
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

    /**
     * Reads a non-empty string from the user.
     *
     * @param scanner scanner used to read input
     * @param message prompt displayed to the user
     * @return non-empty string
     */
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

    /**
     * Reads an integer within the specified range.
     *
     * @param scanner scanner used to read input
     * @param message prompt displayed to the user
     * @param upperBound exclusive upper bound
     * @return integer in the range from 1 to {@code upperBound - 1}
     */
    public static int readIntInRange(Scanner scanner, String message, int upperBound) {
        while (true) {
            int value = readInt(scanner, message);
            if (value > 0 && value < upperBound) {
                return value;
            }
            System.out.println("The number must be in range [1;" + (upperBound - 1) + "]");
        }
    }

    /**
     * Reads a boolean value from the user.
     * Accepts {@code y}/{@code yes} or {@code n}/{@code no}.
     *
     * @param scanner scanner used to read input
     * @param message prompt displayed to the user
     * @return {@code true} if the user entered yes, otherwise {@code false}
     */
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