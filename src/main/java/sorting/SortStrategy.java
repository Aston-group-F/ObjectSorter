package sorting;

import model.CarList;


public interface SortStrategy {
    //ToDo: create classes which will implement this interface

    void sortByPower(CarList carList);

    void sortByModel(CarList carList);

    void sortByYear(CarList carList);


}
