package dataloader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import model.Car;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


class RandomDataLoaderTest {
    @Test
    public void validCountTest() {
        IDataLoader randomLoader = new RandomDataLoader();

        List<Car> carsList = randomLoader.load(5);

        assertEquals(5, carsList.size());
    }

    @Test
    public void invalidCountTest() {
        IDataLoader randomLoader = new RandomDataLoader();

        assertThrows(IllegalArgumentException.class, () -> randomLoader.load(0));
        assertThrows(IllegalArgumentException.class, () -> randomLoader.load(-10));
    }

    @Test
    public void specificCarLoadTest() {
        RandomDataLoader loader = new RandomDataLoader();
        int expectedPower = 100;
        int expectedYear = 2025;
        int expectedModelIndex = 5;

        try (MockedStatic<ThreadLocalRandom> mockRandom = mockStatic(ThreadLocalRandom.class)) {
            ThreadLocalRandom mockInstance = mock(ThreadLocalRandom.class);
            mockRandom.when(ThreadLocalRandom::current).thenReturn(mockInstance);

            when(mockInstance.nextInt(anyInt(), anyInt()))
                    .thenReturn(expectedPower, expectedYear);
            when(mockInstance.nextInt(anyInt()))
                    .thenReturn(expectedModelIndex);

            List<Car> carsList = loader.load(1);

            assertEquals(1, carsList.size());

            Car car = carsList.get(0);
            assertEquals("Hyundai Solaris", car.getModel());
            assertEquals(expectedPower, car.getPower());
            assertEquals(expectedYear, car.getYear());
        }
    }

}