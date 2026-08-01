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

public class FileDataExporter implements DataExporter {
    private final Path path;

    public FileDataExporter(String path) {
        this.path = Path.of(path);
    }

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
