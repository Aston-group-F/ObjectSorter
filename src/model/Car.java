package model;

public class Car {


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", power=" + power +
                ", year=" + year +
                '}';
    }

    private String model;
    private int power;
    private int year;

    private Car(String model, int power, int year) {
        this.model = model;
        this.power = power;
        this.year = year;

    }

    public static Builder builder(){
        return new Builder();

    }

    public static class Builder {

        private String model;
        private int power;
        private int year;

        public Builder setModel(String model)   {
            this.model = model;
            return this;
        }

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(model, power, year);
        }

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


}
