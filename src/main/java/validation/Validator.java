package validation;

import constants.CarConstants;

public final class Validator {

    public static boolean validModel(String model) {

        return model != null && !model.isBlank();
    }

    public static boolean validPower(int power) {

        return power >= CarConstants.MIN_VALID_POWER && power <= CarConstants.MAX_VALID_POWER;
    }

    public static boolean validYear(int year) {

        return year >= CarConstants.FIRST_CAR_YEAR;
    }
}