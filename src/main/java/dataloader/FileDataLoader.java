package dataloader;

import model.Car;
import model.CarList;
import utils.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Loads car data from a file.
 * <p>
 * Each non-empty line of the file is parsed into a {@link Car} object.
 * Invalid lines are skipped during the loading process.
 */
public class FileDataLoader extends AbstractDataLoader{

    /**
     * Path to the file containing car data.
     */
    private final String filePath;

    /**
     * Creates a new data loader that reads car data from the specified file.
     *
     * @param filePath the path to the input file
     * @throws IllegalArgumentException if the file path is {@code null} or empty
     */
    public FileDataLoader(String filePath) {
        if(filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        this.filePath = filePath;
    }

    /**
     * Loads the specified number of cars from the file.
     *
     * @param carsCount the number of cars to load
     * @return a {@link CarList} containing the loaded cars
     * @throws IllegalArgumentException if the file contains fewer cars than requested
     * @throws RuntimeException if an error occurs while reading the file
     */
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
                throw new IllegalArgumentException("The actual number of cars in the file turned "
                    + "out to be less than the expected number");
            }
            System.out.println("\nThe number of cars entered by the user (" + carsCount + ") "
                + "is recorded. If there were others in the file, they will not be processed");
            return cars;
        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + filePath);
        }
    }

    /**
     * Parses a single line of the input file into a {@link Car}.
     * <p>
     * Returns {@code null} if the line has an invalid format or contains
     * invalid numeric values.
     *
     * @param line the line to parse
     * @return the parsed {@link Car}, or {@code null} if the line cannot be parsed
     */
    private Car parseLine(String line) {
        String[] parts = line.split(FileUtils.SEPARATOR);
        if (parts.length >= 3) {
            try {
                return Car.builder()
                        .model(parts[0].trim())
                        .year(Integer.parseInt(parts[1].trim()))
                        .power(Integer.parseInt(parts[2].trim()))
                        .build();
            } catch (NumberFormatException e) {
                System.err.println("Parsing error in line: " + line);
                return null;
            }
        } else {
            System.err.printf("Incorrect row entry format: '%s', the data from this row will "
                + "not be parsed.%n", line);
            return null;
        }
    }
}
