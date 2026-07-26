import model.Car;

public class main {

    public static void main(String[] args) {

        Car car = Car.builder()
                .setModel("VAZ")
                .setPower(250)
                .setYear(2020)
                .build();
        System.out.println(car);
    }
}
