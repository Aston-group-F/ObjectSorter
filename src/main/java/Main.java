import model.Car;

public class Main {

    public static void main(String[] args) {

        var car0 = new Car.Builder().model("").power(123).year(2000).build(); // validation failed on model
        var car1 = new Car.Builder().model("BMW").power(-123).year(2000).build(); // validation failed on power
        var car2 = new Car.Builder().model("BMW").power(123).year(1000).build(); // validation failed on year
        var car3 = new Car.Builder().model("BMW").power(123).year(2000).build(); // correct
    }
}