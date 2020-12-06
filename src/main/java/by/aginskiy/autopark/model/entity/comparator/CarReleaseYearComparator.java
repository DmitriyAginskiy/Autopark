package by.aginskiy.autopark.model.entity.comparator;

import by.aginskiy.autopark.model.entity.Car;

import java.util.Comparator;

public class CarReleaseYearComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getReleaseYear(), o2.getReleaseYear());
    }
}
