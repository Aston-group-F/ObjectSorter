package dataloader;

import model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileDataLoader extends AbstractDataLoader{
    private final String filePath;


    public FileDataLoader(String filePath) {
        if(filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        this.filePath = filePath;
    }

    @Override
    protected List<Car> loadData(int carsCount) {
        List<Car> cars = new ArrayList<>();
        int currentCarsCount = 0;
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            for(String line : lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList()) {
                if(currentCarsCount >= carsCount) {
                    System.err.println("The number of cars entered by the user has already been recorded, the remaining lines will be ignored");
                    break;
                }

                String[] parts = line.split(";");

                if (parts.length >= 3) {
                    try {
                        String model = parts[0].trim();
                        int year = Integer.parseInt(parts[1].trim());
                        int power = Integer.parseInt(parts[2].trim());

                        cars.add(Car.builder().model(model).year(year).power(power).build());
                        currentCarsCount++;
                    } catch (NumberFormatException e) {
                        System.err.println("Parsing error in line: " + line);
                    }
                } else {
                    System.err.printf("Incorrect row entry format: '%s', the data from this row will not be parsed.", line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + filePath);
        }
        if(currentCarsCount < carsCount) {
            throw new IllegalArgumentException("The actual number of cars in the file turned out to be less than the expected number");
        }

        return cars;
    }
}
