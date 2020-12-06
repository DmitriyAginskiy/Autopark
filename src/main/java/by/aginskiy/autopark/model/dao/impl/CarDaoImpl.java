package by.aginskiy.autopark.model.dao.impl;

import by.aginskiy.autopark.exception.DaoException;
import by.aginskiy.autopark.exception.InvalidStorageIndexException;
import by.aginskiy.autopark.model.dao.CarDao;
import by.aginskiy.autopark.model.dao.warehouse.CarWarehouse;
import by.aginskiy.autopark.model.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDaoImpl implements CarDao {

    private static Logger logger = LogManager.getLogger();
    private static CarDaoImpl carDaoInstance;
    private static CarWarehouse carWarehouse = CarWarehouse.getInstance();

    private CarDaoImpl() {

    }

    public static CarDaoImpl getInstance() {
        if(carDaoInstance == null) {
            carDaoInstance = new CarDaoImpl();
        }
        return carDaoInstance;
    }

    @Override
    public List<Car> findAll() throws DaoException {
        List<Car> result = new ArrayList<>();
        int storageLength = carWarehouse.getSize();
        try {
            for(int i = 0; i < storageLength; i++) {
                result.add(carWarehouse.getElement(i));
            }
        } catch(InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Returned full CarWarehouse collection");
        return result;
    }

    @Override
    public Optional<Car> findById(int id) throws DaoException {
        Optional<Car> result = Optional.empty();
        int storageLength = carWarehouse.getSize();
        int i = 0;
        try {
            while(i < storageLength) {
                if(carWarehouse.getElement(i).getId() == id) {
                    result = Optional.of(carWarehouse.getElement(i));
                    break;
                }
                i++;
            }
        } catch(InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Id search performed");
        return result;
    }

    @Override
    public List<Car> findByBrand(String brand) throws DaoException {
        List<Car> result = new ArrayList<>();
        int storageLength = carWarehouse.getSize();
        try {
            for(int i = 0; i < storageLength; i++) {
                if(brand.equals(carWarehouse.getElement(i).getBrand())) {
                    result.add(carWarehouse.getElement(i));
                }
            }
        } catch (InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Search by brand performed");
        return result;
    }

    @Override
    public List<Car> findByModel(String model) throws DaoException {
        List<Car> result = new ArrayList<>();
        int storageLength = carWarehouse.getSize();
        try {
            for(int i = 0; i < storageLength; i++) {
                if(model.equals(carWarehouse.getElement(i).getModel())) {
                    result.add(carWarehouse.getElement(i));
                }
            }
        } catch(InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Search by model performed");
        return result;
    }

    @Override
    public boolean update(int id, Car car) throws DaoException {
        int storageLength = carWarehouse.getSize();
        int i = 0;
        boolean isUpdated = false;
        try {
            while(i < storageLength) {
                if(id == carWarehouse.getElement(i).getId()) {
                    carWarehouse.setElement(i, car);
                    isUpdated = true;
                    break;
                }
                i++;
            }
        } catch(InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Element was updated ", id);
        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        if(!findById(id).isPresent()) {
            throw new DaoException("There is no car with an id " + id);
        }
        int storageLength = carWarehouse.getSize();
        int i = 0;
        boolean isDeleted = false;
        try {
            while(i < storageLength) {
                if(id == carWarehouse.getElement(i).getId()) {
                    carWarehouse.removeElement(i);
                    isDeleted = true;
                    break;
                }
            }
        } catch(InvalidStorageIndexException exception) {
            throw new DaoException(exception);
        }
        logger.info("Element was deleted ", id);
        return isDeleted;
    }

    @Override
    public void add(Car car) throws DaoException {
        if(carWarehouse.contains(car)) {
            throw new DaoException("The object is already in the collection (add(Car car))");
        }
        logger.info("Element was added ", car.toString());
        carWarehouse.addElement(car);
    }
}
