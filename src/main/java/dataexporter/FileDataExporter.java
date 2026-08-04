package dataexporter;

import model.Car;
import model.CarList;
import utils.FileUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Exports car data to a file.
 * <p>
 * Cars are written to the specified file in a text format.
 * If the file or its parent directories do not exist, they are created.
 */
public class FileDataExporter implements DataExporter {

    /**
     * Path to the output file.
     */
    private final Path path;

    /**
     * Creates a new exporter that writes car data to the specified file.
     *
     * @param path the path to the output file
     */
    public FileDataExporter(String path) {
        this.path = Path.of(path);
    }

    /**
     * Writes the specified collection of cars to the output file.
     *
     * @param carList the collection of cars to export
     * @throws RuntimeException if an error occurs while writing to the file
     */
    @Override
    public void export(CarList carList) {
        try {
            Files.createDirectories(path.getParent());

            BufferedWriter writer = Files.newBufferedWriter(
                    path,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            for (Car car : carList) {
                writer.write(FileUtils.representativeString(car));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("File writting error: " + path);
        }
    }
}
