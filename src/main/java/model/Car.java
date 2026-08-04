package model;

import validation.Validator;
import constants.CarConstants;

import java.util.Objects;

/**
 * Represents a car with model, power and production year.
 * Instances of this class are created using the {@link Builder}.
 */
public class Car {
    private final String model;
    private final int power;
    private final int year;

    /**
     * Creates a car using the specified builder.
     *
     * @param builder builder containing car properties
     */
    private Car(Builder builder) {
        this.model = builder.model;
        this.power = builder.power;
        this.year = builder.year;
    }

    /**
     * Returns the car model.
     *
     * @return car model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the engine power.
     *
     * @return engine power
     */
    public int getPower() {
        return power;
    }

    /**
     * Returns the production year.
     *
     * @return production year
     */
    public int getYear() {
        return year;
    }

    /**
     * Creates a new builder instance.
     *
     * @return new car builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for creating {@link Car} instances.
     */
    public static class Builder {
        private String model;
        private int power;
        private int year;

        /**
         * Sets the car model.
         *
         * @param model car model
         * @return current builder
         */
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the engine power.
         *
         * @param power engine power
         * @return current builder
         */
        public Builder power(int power) {
            this.power = power;
            return this;
        }

        /**
         * Sets the production year.
         *
         * @param year production year
         * @return current builder
         */
        public Builder year(int year) {
            this.year = year;
            return this;
        }

        /**
         * Builds a new {@link Car} instance.
         *
         * @return created car
         * @throws IllegalArgumentException if any parameter is invalid
         */
        public Car build() {
            if (!Validator.validModel(model)) {
                throw new IllegalArgumentException("Incorrect car model");
            }

            if (!Validator.validPower(power)) {
                throw new IllegalArgumentException("The car power should be between " + CarConstants.MIN_VALID_POWER + " and " + CarConstants.MAX_VALID_POWER);
            }

            if (!Validator.validYear(year)) {
                throw new IllegalArgumentException("The car year should be between " + CarConstants.FIRST_CAR_YEAR + " and " + CarConstants.CURRENT_YEAR);
            }
            return new Car(this);
        }
    }

    /**
     * Returns the string representation of the car.
     *
     * @return string representation of the car
     */
    @Override
    public String toString() {
        return "Car { model = " + model + ", power = " + power + ", year = " + year + " }";
    }

    /**
     * Compares this car with another object.
     *
     * @param o object to compare
     * @return {@code true} if objects are equal, otherwise {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Car car))
            return false;

        return power == car.power && year == car.year && model.equalsIgnoreCase(car.model);
    }

    /**
     * Returns the hash code of this car.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(model.toLowerCase(), power, year);
    }
}