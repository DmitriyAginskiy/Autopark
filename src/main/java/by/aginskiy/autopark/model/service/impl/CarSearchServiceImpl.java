package by.aginskiy.autopark.model.service.impl;

import by.aginskiy.autopark.exception.DaoException;
import by.aginskiy.autopark.model.dao.impl.CarDaoImpl;
import by.aginskiy.autopark.model.entity.Car;
import by.aginskiy.autopark.model.service.CarSearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarSearchServiceImpl implements CarSearchService {

    private static Logger logger = LogManager.getLogger();
    private static final CarDaoImpl CAR_DAO = CarDaoImpl.getInstance();

    @Override
    public Optional<Car> searchById(int id) {
        Optional<Car> result = Optional.empty();
        try {
            result = CAR_DAO.findById(id);
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        return result;
    }

    @Override
    public List<Car> searchByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        try {
            result = CAR_DAO.findByBrand(brand);
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        return result;
    }

    @Override
    public List<Car> searchByModel(String model) {
        List<Car> result = new ArrayList<>();
        try {
            result = CAR_DAO.findByBrand(model);
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        return result;
    }
}
