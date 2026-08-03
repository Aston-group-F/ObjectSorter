package utils;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputUtilsTest {

    @Test
    void readPositiveIntValidTest() {

        Scanner scanner = new Scanner("25\n");

        int value = InputUtils.readPositiveInt(scanner, "Number: ");

        assertEquals(25, value);
    }

    @Test
    void readPositiveIntNegativeValueTest() {

        Scanner scanner = new Scanner("""
            -5
            10
            """);

        int value = InputUtils.readPositiveInt(scanner, "Number: ");

        assertEquals(10, value);
    }

    @Test
    void readPositiveIntZeroValueTest() {

        Scanner scanner = new Scanner("""
            0
            15
            """);

        int value = InputUtils.readPositiveInt(scanner, "Number: ");

        assertEquals(15, value);
    }

    @Test
    void readIntInvalidInputTest() {

        Scanner scanner = new Scanner("""
            abc
            123
            """);

        int value = InputUtils.readInt(scanner, "Number: ");

        assertEquals(123, value);
    }

    @Test
    void readStringEmptyInputTest() {

        Scanner scanner = new Scanner("""
            
            Toyota
            """);

        String value = InputUtils.readString(scanner, "Model: ");

        assertEquals("Toyota", value);
    }
}