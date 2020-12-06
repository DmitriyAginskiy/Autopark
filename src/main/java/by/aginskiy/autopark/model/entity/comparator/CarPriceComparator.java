package by.aginskiy.autopark.model.entity.comparator;

import by.aginskiy.autopark.model.entity.Car;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
