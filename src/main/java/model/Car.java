package model;

import validation.Validator;
import constants.CarConstants;

public class Car {

    private final String model;
    private final int power;
    private final int year;

    private Car(Builder builder) {

        this.model = builder.model;
        this.power = builder.power;
        this.year = builder.year;
    }

    public String getModel() {

        return model;
    }

    public int getPower() {

        return power;
    }

    public int getYear() {

        return year;
    }

    public static Builder builder() {

        return new Builder();
    }

    public static class Builder {

        private String model;
        private int power;
        private int year;

        public Builder model(String model) {

            this.model = model;
            return this;
        }

        public Builder power(int power) {

            this.power = power;
            return this;
        }

        public Builder year(int year) {

            this.year = year;
            return this;
        }

        public Car build() {

            if (!Validator.validModel(model)) {

                throw new IllegalArgumentException("Incorrect car model");
            }

            if (!Validator.validPower(power)) {

                throw new IllegalArgumentException("Minimum car power - " + CarConstants.MIN_VALID_POWER);
            }

            if (!Validator.validYear(year)) {

                throw new IllegalArgumentException("The year of production cannot be less than - " + CarConstants.FIRST_CAR_YEAR);
            }

            return new Car(this);
        }
    }

    @Override
    public String toString() {

        return "Car { model = " + model + ", power = " + power + ", year = " + year + "}";
    }
}