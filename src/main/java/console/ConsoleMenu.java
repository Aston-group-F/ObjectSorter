package console;

public class ConsoleMenu {

    public static final String CARS_COUNT = "Cars count: ";
    public static final String CHOOSE_OPTION = "Choose option: ";

    public void showMainMenu() {

        System.out.println();
        System.out.println("1. Manual");
        System.out.println("2. Random");
        System.out.println("3. File");
        System.out.println("4. Print");
        System.out.println("5. Sort");
        System.out.println("6. Find count of identical cars");
        System.out.println("7. Export to file");
        System.out.println("0. Exit");
    }

    public void showAdded() {

        System.out.println("Added.");
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
