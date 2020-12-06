package by.aginskiy.autopark.model.service.impl;

import by.aginskiy.autopark.exception.DaoException;
import by.aginskiy.autopark.model.dao.impl.CarDaoImpl;
import by.aginskiy.autopark.model.entity.Car;
import by.aginskiy.autopark.model.entity.comparator.CarIdComparator;
import by.aginskiy.autopark.model.entity.comparator.CarPriceComparator;
import by.aginskiy.autopark.model.entity.comparator.CarReleaseYearComparator;
import by.aginskiy.autopark.model.service.CarSortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarSortServiceImpl implements CarSortService {

    private static Logger logger = LogManager.getLogger();
    private static final CarDaoImpl CAR_DAO = CarDaoImpl.getInstance();

    @Override
    public void sortById() {
        CarIdComparator idComparator = new CarIdComparator();
        try {
            List<Car> carList = CAR_DAO.findAll();
            carList.sort(idComparator);
            int carListSize = carList.size();
            for(int i = 0; i < carListSize; i++) {
                CAR_DAO.update(i, carList.get(i));
            }
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        logger.info("Car warehouse was sorted by ID");
    }

    @Override
    public void sortByPrice() {
        CarPriceComparator priceComparator = new CarPriceComparator();
        try {
            List<Car> carList = CAR_DAO.findAll();
            carList.sort(priceComparator);
            int carListSize = carList.size();
            for(int i = 0; i < carListSize; i++) {
                CAR_DAO.update(i, carList.get(i));
            }
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        logger.info("Car warehouse was sorted by price");
    }

    @Override
    public void sortByReleaseYear() {
        CarReleaseYearComparator releaseYearComparator = new CarReleaseYearComparator();
        try {
            List<Car> carList = CAR_DAO.findAll();
            carList.sort(releaseYearComparator);
            int carListSize = carList.size();
            for(int i = 0; i < carListSize; i++) {
                CAR_DAO.update(i, carList.get(i));
            }
        } catch(DaoException exception) {
            logger.error("An exception was generated: ", exception);
        }
        logger.info("Car warehouse was sorted by release year");
    }
}
