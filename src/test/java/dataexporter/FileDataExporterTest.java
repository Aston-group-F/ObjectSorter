package dataexporter;

import static org.junit.jupiter.api.Assertions.*;

import model.Car;
import model.CarList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import utils.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class FileDataExporterTest {
    @TempDir
    Path tempDir;

    private Path testFile;

    @BeforeEach
    void setUp() {
        testFile = tempDir.resolve("test_cars.txt");
    }

    @Test
    void validExportCarListTest() throws IOException {
        CarList carList = new CarList();
        carList.add(Car.builder().model("Toyota Camry").year(2020).power(203).build());
        carList.add(Car.builder().model("BMW X5").year(2019).power(340).build());
        carList.add(Car.builder().model("Mercedes E-Class").year(2021).power(255).build());
        int carsSize = carList.size();

        DataExporter exporter =  new FileDataExporter(testFile.toString());
        exporter.export(carList);

        assertTrue(Files.exists(testFile));
        List<String> lines = Files.readAllLines(testFile);
        assertEquals(carsSize, lines.size());
        for (int i = 0; i < carsSize; i++) {
            assertEquals(FileUtils.representativeString(carList.get(i)), lines.get(i));
        }
    }
}