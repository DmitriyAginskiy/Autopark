package by.aginskiy.autopark.model.dao.impl;

import by.aginskiy.autopark.exception.DaoException;
import by.aginskiy.autopark.model.entity.Car;
import by.aginskiy.autopark.model.entity.Color;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CarDaoImplTest {

    private static CarDaoImpl carDao;

    @BeforeClass
    private void setUp() {
        carDao = CarDaoImpl.getInstance();

    }

    @BeforeMethod(onlyForGroups = "findAll")
    public void SetUpFindAll() {
        Car car = new Car("Honda", "123", 2010, Color.BLACK, new BigDecimal(2000), "0154");
        try {
            carDao.add(car);
        } catch(DaoException e) {
            e.printStackTrace();
        }
    }

    @Test(groups = "findAll")
    public void testFindAll() {
        List<Car> carList = new ArrayList<>();
        try {
            carList = carDao.findAll();
        } catch(DaoException exception) {
            exception.printStackTrace();
        }
        boolean actual = carList.size() == 1;
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindById() {
        Optional<Car> car = Optional.empty();
        try {
            car = carDao.findById(1);
        } catch(DaoException exception) {
            exception.printStackTrace();
        }
        Car car1 = car.get();
        boolean actual = car1.getId() == 1;
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindByBrand() {
        List<Car> carList = new ArrayList<>();
        try {
            carList = carDao.findByBrand("Honda");
        } catch(DaoException exception) {
            exception.printStackTrace();
        }
        boolean actual = carList.size() == 1;
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindByModel() {
        List<Car> carList = new ArrayList<>();
        try {
            carList = carDao.findByModel("123");
        } catch(DaoException exception) {
            exception.printStackTrace();
        }
        boolean actual = carList.size() == 1;
        Assert.assertTrue(actual);
    }

    @Test
    public void testUpdate() {
        Car car = new Car("Honda", "123", 2020, Color.BLACK, new BigDecimal(2000), "0154");
        Car car2 = new Car("Honda", "123", 2022, Color.BLACK, new BigDecimal(2000), "0154");
        boolean actual = false;
        try {
            carDao.add(car);
            carDao.update(1, car2);
            actual = carDao.findAll().get(0).getReleaseYear() == 2022;
        } catch(DaoException exception) {
            exception.printStackTrace();
        }
        Assert.assertTrue(actual);
    }

    @Test
    public void testDelete() {
        boolean actual = false;
        try {
            carDao.delete(0);
            actual = carDao.findAll().size() == 0;
        } catch(DaoException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(actual);
    }

    @Test
    public void testAdd() {
        Car car1 = new Car("Honda", "123", 2020, Color.BLACK, new BigDecimal(2000), "0154");
        boolean actual = false;
        try {
            carDao.add(car1);
            actual = carDao.findAll().size() == 1;
        } catch(DaoException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(actual);
    }
}