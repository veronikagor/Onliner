package utils;

import utils.driverUtils.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final String PATH_TO_BROWSER_DRIVER = "src/test/resources/framework.properties";

    public static String getBaseUrl() {
        return getProperty("url");
    }

    public static BrowserType getBrowser() {
        return BrowserType.valueOf(getProperty("browser"));
    }

    public static int getDefaultWebDriverWait() {
        return Integer.parseInt(getProperty("defaultWebDriverWaitSeconds"));
    }

    public static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(PATH_TO_BROWSER_DRIVER)) {
            properties.load(input);
        } catch (IOException ex) {
            Log.error(String.format("Cannot read property value for [%s]", propertyName));
            throw new IllegalArgumentException(String.format("File not found with path: [%s] ", PATH_TO_BROWSER_DRIVER));
        }
        return properties.getProperty(propertyName);
    }
}
