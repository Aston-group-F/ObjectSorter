package console;
/**
 * Represents the console menu of the application.
 * Provides methods for displaying available user actions and options.
 */
public class ConsoleMenu {
    public final String CARS_COUNT = "Cars count: ";
    public final String CHOOSE_OPTION = "Choose option: ";
    /**
     * Displays the main application menu.
     */
    public void showMainMenu() {
        System.out.println();
        System.out.println("1. Fill in collection");
        System.out.println("2. Print");
        System.out.println("3. Sort");
        System.out.println("4. Find count of identical cars");
        System.out.println("5. Export to file");
        System.out.println("6. Clear");
        System.out.println("0. Exit");
    }
    /**
     * Displays available methods for filling the car collection.
     */
    public void showFillingMethod() {
        System.out.println("Choose filling method:");
        System.out.println("1. Manual");
        System.out.println("2. Random");
        System.out.println("3. File");
    }
    /**
     * Displays a message confirming that cars were added successfully.
     */
    public void showAdded() {
        System.out.println("\nAdded.");
    }

    /**
     * Displays available sorting algorithms.
     */
    public void showSortAlgorithms() {
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");
        System.out.println("6. Heap Sort");
    }
    /**
     * Displays a question about using conditional sorting.
     */
    public void showUseConditional() {
        System.out.println("Choose will conditional sorting be used? (y/n)");
    }
    /**
     * Displays available car fields for sorting.
     *
     * @param useConditional indicates whether conditional sorting is enabled
     */
    public void showCarFields(boolean useConditional) {
        System.out.println("Choose field:");
        System.out.println("1. Power");
        System.out.println("2. Year");
        if (!useConditional) {
            System.out.println("3. Model");
        }
    }
}
