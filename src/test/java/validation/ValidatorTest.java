package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    public void validModelTest() {
        assertTrue(Validator.validModel("NOT_EMPTY_STRING"));
    }

    @Test
    public void invalidModelTest() {
        assertFalse(Validator.validModel(""));
        assertFalse(Validator.validModel(null));
    }

    @Test
    public void validPowerTest() {
        assertTrue(Validator.validPower(150));
    }

    @Test
    public void invalidPowerTest() {
        assertFalse(Validator.validPower(-10));
        assertFalse(Validator.validPower(0));
        assertFalse(Validator.validPower(Integer.MAX_VALUE));
    }

    @Test
    public void validYearTest() {
        assertTrue(Validator.validYear(1986));
    }

    @Test
    public void invalidYearTest() {
        assertFalse(Validator.validYear(-10));
        assertFalse(Validator.validYear(100));
        assertFalse(Validator.validYear(Integer.MAX_VALUE));
    }
}