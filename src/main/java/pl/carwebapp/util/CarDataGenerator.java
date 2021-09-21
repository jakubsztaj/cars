package pl.carwebapp.util;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class CarDataGenerator {

    public static String randomizeVin() {
        return randomNumeric(1) + randomAlphabetic(4).toUpperCase() + randomNumeric(5) + randomAlphabetic(1).toUpperCase()
                + randomNumeric(6);
    }

    public static String randomPlatesNumber() {
        return randomAlphabetic(3).toUpperCase() + randomNumeric(5);
    }

    public static String randomPersonalIdNumber() {
        return randomNumeric(13);
    }
}