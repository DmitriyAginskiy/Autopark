package by.aginskiy.autopark.model.reader;

import by.aginskiy.autopark.model.entity.Car;
import by.aginskiy.autopark.model.entity.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {

    private static Logger logger = LogManager.getLogger();

    public List<Car> readFromFile(String fileName) {
        List<Car> result = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String brand;
            String model;
            int releaseYear = 0;
            Color color;
            BigDecimal price;
            String registrationNumber;
            while (scanner.hasNextLine()) {
                String carValues = scanner.nextLine();
                String[] carFields = carValues.split(" ");
                brand = carFields[0];
                model = carFields[1];
                releaseYear = Integer.parseInt(carFields[2]);
                color = Color.valueOf(carFields[3]);
                price = new BigDecimal(Double.parseDouble(carFields[4]));
                registrationNumber = carFields[5];
                Car car = new Car(brand, model, releaseYear, color, price, registrationNumber);
                result.add(car);
            }
        } catch (FileNotFoundException exception) {
            logger.error("File not found ", exception);
        } finally {
            scanner.close();
        }
        logger.info("Generated list of cars");
        return result;
    }
}
