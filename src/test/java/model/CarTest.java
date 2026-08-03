package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void equalsTest() {
        Car car1 = Car.builder().model("Mazda cx-6").power(254).year(2016).build();
        Car car2 = Car.builder().model("Mazda cx-3").power(180).year(2013).build();
        Car car3 = Car.builder().model("Mazda cx-6").power(254).year(2016).build();

        assertEquals(car1, car1);
        assertNotEquals(new Object(), car1);
        assertNotEquals(car1, car2);
        assertEquals(car1, car3);
    }

    @Test
    public void toStringTest() {
        Car car = Car.builder().model("Mazda cx-6").power(254).year(2016).build();
        assertEquals("Car { model = Mazda cx-6, power = 254, year = 2016 }", car.toString());
    }

    @Test
    public void invalidCarTest() {
        assertThrows(IllegalArgumentException.class, () -> Car.builder().model("").power(254).year(2016).build());
        assertThrows(IllegalArgumentException.class, () -> Car.builder().model("Mazda").power(0).year(2016).build());
        assertThrows(IllegalArgumentException.class, () -> Car.builder().model("Mazda").power(254).year(-1).build());
    }

}