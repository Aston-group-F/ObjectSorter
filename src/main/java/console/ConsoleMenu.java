package console;

public class ConsoleMenu {

    public final String CARS_COUNT = "Cars count: ";
    public final String CHOOSE_OPTION = "Choose option: ";

    public void showMainMenu() {

        System.out.println();
        System.out.println("1. Fill in collection");
        System.out.println("2. Print");
        System.out.println("3. Sort");
        System.out.println("4. Find count of identical cars");
        System.out.println("5. Export to file");
        System.out.println("9. Clear");
        System.out.println("0. Exit");
    }

    public void showFillingMethod() {

        System.out.println("Choose filling method:");
        System.out.println("1. Manual");
        System.out.println("2. Random");
        System.out.println("3. File");
    }

    public void showAdded() {

        System.out.println("\nAdded.");
    }


    public void showSortAlgorithms() {
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");
        System.out.println("6. Heap Sort");
    }

    public void showUseConditional() {
        System.out.println("Choose will conditional sorting be used? (y/n)");
    }

    public void showCarFields(boolean useConditional) {
        System.out.println("Choose field:");
        System.out.println("1. Power");
        System.out.println("2. Year");
        if (!useConditional) {
            System.out.println("3. Model");
        }
    }
}
