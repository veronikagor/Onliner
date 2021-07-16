package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.driverUtils.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Logger logger = LoggerFactory.getLogger(PropertyReader.class);

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
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(PATH_TO_BROWSER_DRIVER);
            prop.load(input);
        } catch (IOException ex) {
            logger.error("Cannot read property value for " + propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }
}
