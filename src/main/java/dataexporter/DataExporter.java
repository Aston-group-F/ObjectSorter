package dataexporter;

import model.CarList;

/**
 * Defines a contract for exporting a {@link CarList}.
 * <p>
 * Implementations may export car data to different destinations,
 * such as files or the console.
 */
public interface DataExporter {

    /**
     * Exports the specified collection of cars.
     *
     * @param carList the collection of cars to export
     */
    void export(CarList carList);
}
