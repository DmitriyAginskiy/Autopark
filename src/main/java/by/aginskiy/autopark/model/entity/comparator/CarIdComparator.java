package by.aginskiy.autopark.model.entity.comparator;

import by.aginskiy.autopark.model.entity.Car;

import java.util.Comparator;

public class CarIdComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
