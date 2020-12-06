package by.aginskiy.autopark.model.dao.warehouse;

import by.aginskiy.autopark.exception.InvalidStorageIndexException;
import by.aginskiy.autopark.model.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarWarehouse {

    private static CarWarehouse carWarehouse;
    private List<Car> carList;

    private CarWarehouse() {
        carList = new ArrayList<Car>();
    }

    public static CarWarehouse getInstance() {
        if(carWarehouse == null) {
            carWarehouse = new CarWarehouse();
        }
        return carWarehouse;
    }

    public boolean contains(Car car) {
        boolean isContains = false;
        int carListLength = carList.size();
        int i = 0;
        while(i < carListLength) {
            if(car.equals(carList.get(i))) {
                isContains = true;
                break;
            }
            i++;
        }
        return isContains;
    }

    public void addElement(Car car) {
        carList.add(car);
    }

    public void addElement(int index, Car car) throws InvalidStorageIndexException {
        if(index < 0 || index >= carList.size()) {
            throw new InvalidStorageIndexException("Invalid index value in method addElement(int index, Car car): " + index);
        }
        carList.add(index, car);
    }

    public Car getElement(int index) throws InvalidStorageIndexException {
        if(index < 0 || index >= carList.size()) {
            throw new InvalidStorageIndexException("Invalid index value in method getElement(int index): " + index);
        }
        return carList.get(index);
    }

    public void setElement(int index, Car car) throws InvalidStorageIndexException {
        if(index < 0 || index >= carList.size()) {
            throw new InvalidStorageIndexException("Invalid index value in method setElement(int index, Car car): " + index);
        }
        carList.set(index, car);
    }

    public int getSize() {
        return carList.size();
    }

    public void removeElement(int index) throws InvalidStorageIndexException {
        if(index < 0 || index >= carList.size()) {
            throw new InvalidStorageIndexException("Invalid index value in method removeElement(int index): " + index);
        }
        carList.remove(index);
    }
}
