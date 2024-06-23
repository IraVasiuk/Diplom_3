package constants;

import org.apache.commons.lang3.RandomStringUtils;

public class Data {
    //генерирование случайных значений для полей email, password, name
    public static String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(10) + "@burger.ru";
    public static String RANDOM_PASSWORD = RandomStringUtils.randomNumeric(6);
    public static String RANDOM_PASSWORD_4_CHAR = RandomStringUtils.randomNumeric(4);
    public static String RANDOM_NAME = RandomStringUtils.randomAlphabetic(10);
}
