package strategy;

import  model.Car;

public class BubbleSortStrategy implements SortStrategy {

    @Override
    public void sort(Car[] cars) {


        for (int i = 0; i < cars.length - 1; i++) {

            for (int j = 0; j < cars.length - 1 - i; j++) {

                if (cars[j].getPower() > cars[j + 1].getPower()) {

                    Car temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;

                }

            }
        }

    }

}
