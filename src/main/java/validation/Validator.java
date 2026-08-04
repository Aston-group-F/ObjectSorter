package validation;

import constants.CarConstants;
/**
 * Provides validation methods for car fields.
 */
public final class Validator {
    /**
     * Checks whether the car model is valid.
     *
     * @param model car model name
     * @return true if model is not null and not blank
     */
    public static boolean validModel(String model) {
        return model != null && !model.isBlank();
    }
    /**
     * Checks whether the car power is within allowed range.
     *
     * @param power car engine power
     * @return true if power is valid
     */
    public static boolean validPower(int power) {
        return power >= CarConstants.MIN_VALID_POWER && power <= CarConstants.MAX_VALID_POWER;
    }
    /**
     * Checks whether the car production year is valid.
     *
     * @param year car production year
     * @return true if year is between the first car year and current year
     */
    public static boolean validYear(int year) {
        return year >= CarConstants.FIRST_CAR_YEAR && year <= CarConstants.CURRENT_YEAR;
    }
}