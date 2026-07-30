import model.Car;
import strategy.BubbleSortStrategy;
import strategy.SortStrategy;


public class Main {

    public static void main(String[] args) {

        Car[] cars = new Car[5];
                cars[0] = Car.builder()
                        .setModel("VAZ")
                        .setPower(250)
                        .setYear(2020)
                        .build();


                cars[1] = Car.builder()
                        .setModel("Uaz")
                        .setPower(150)
                        .setYear(2000)
                        .build();


                cars[2] = Car.builder()
                        .setModel("Gaz")
                        .setPower(100)
                        .setYear(2005)
                        .build();

                cars[3] = Car.builder()
                        .setModel("MAZ")
                        .setPower(350)
                        .setYear(2010)
                        .build();


                cars[4] = Car.builder()
                        .setModel("KRAZ")
                        .setPower(200)
                        .setYear(1980)
                        .build();

        SortStrategy strategy = new BubbleSortStrategy();
        strategy.sort(cars);


        for(Car car: cars) {
            System.out.println(car);
        }

    }
}
