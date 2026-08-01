package utils;

import model.Car;

public final class FileUtils {

    public static final String SEPARATOR = ";";

    public static String representativeString(Car car) {
        return car.getModel() + SEPARATOR + car.getYear() + SEPARATOR + car.getPower();
    }
}
