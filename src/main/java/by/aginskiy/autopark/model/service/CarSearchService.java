package by.aginskiy.autopark.model.service;

import by.aginskiy.autopark.model.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarSearchService {

    Optional<Car> searchById(int id);

    List<Car> searchByBrand(String brand);

    List<Car> searchByModel(String model);
}
