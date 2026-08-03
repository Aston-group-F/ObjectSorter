package utils;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {
    @Test
    void readPositiveIntValidTest() {

        Scanner scanner = new Scanner("""
            25
            """);

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
    public void readIntInRangeTest() {
        Scanner scanner = new Scanner("""
                
                string
                
                
                0.25
                
                -10
                
                100
                5
                """);
        assertEquals(5, InputUtils.readIntInRange(scanner, "", 6));
    }

    @Test
    void readStringEmptyInputTest() {

        Scanner scanner = new Scanner("""
                
                Toyota
                """);

        String value = InputUtils.readString(scanner, "Model: ");

        assertEquals("Toyota", value);
    }

    @Test
    public void readBooleanTest() {
        Scanner scanner = new Scanner("""
                string
                
                -10
                
                y
                """);
        assertTrue(InputUtils.readBoolean(scanner, ""));
        scanner = new Scanner("""
                string
                
                -10
                
                yes
                """);
        assertTrue(InputUtils.readBoolean(scanner, ""));
        scanner = new Scanner("""
                string
                
                -10
                
                n
                """);
        assertFalse(InputUtils.readBoolean(scanner, ""));
        scanner = new Scanner("""
                string
                
                -10
                
                no
                """);
        assertFalse(InputUtils.readBoolean(scanner, ""));
    }
}