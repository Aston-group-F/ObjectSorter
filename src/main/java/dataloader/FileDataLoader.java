package dataloader;

import model.Car;
import model.CarList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
    protected CarList loadData(int carsCount) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            CarList cars = lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .map(this::parseLine)
                    .filter(Objects::nonNull)
                    .limit(carsCount)
                    .collect(Collectors.toCollection(CarList::new));

            if (cars.size() < carsCount) {
                throw new IllegalArgumentException("The actual number of cars in the file turned out to be less than the expected number");
            }

            System.out.println("The number of cars entered by the user (" + carsCount + ") is recorded. If there were others in the file, they will not be processed");

            return cars;

        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + filePath);
        }
    }

    private Car parseLine(String line) {
        String[] parts = line.split(";");
        if (parts.length >= 3) {
            try {
                return Car.builder()
                        .model(parts[0].trim())
                        .power(Integer.parseInt(parts[1].trim()))
                        .year(Integer.parseInt(parts[2].trim()))
                        .build();
            } catch (NumberFormatException e) {
                System.err.println("Parsing error in line: " + line);
                return null;
            }
        } else {
            System.err.printf("Incorrect row entry format: '%s', the data from this row will not be parsed.%n", line);
            return null;
        }
    }
}
