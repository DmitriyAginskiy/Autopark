package by.aginskiy.autopark.model.dao;

import by.aginskiy.autopark.exception.DaoException;
import by.aginskiy.autopark.model.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {

    List<Car> findAll() throws DaoException;

    Optional<Car> findById(int id) throws DaoException;

    List<Car> findByBrand(String brand) throws DaoException;

    List<Car> findByModel(String model) throws DaoException;

    boolean update(int id, Car car) throws DaoException;

    boolean delete(int id) throws DaoException;

    void add(Car car) throws DaoException;
}
