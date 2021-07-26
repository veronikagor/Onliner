package utils.driverUtils;

import org.openqa.selenium.WebDriver;
import utils.Log;
import utils.PropertyReader;

public class DriverHelper {
    private static WebDriver driver;
    private static DriverManager driverManager;

    public static WebDriver getDriver() {
        if (driver == null) {
            driverManager = DriverManagerFactory.getManager(PropertyReader.getBrowser());
            driver = driverManager.getDriver();
        }
        return driver;
    }

    public static void goToUrl(String url) {
        Log.info("Go to " + url);
        getDriver().get(url);
    }

    public static void closeDriver() {
        Log.info("WebDriver is successfully close");
        getDriver().close();
    }

    public static void quitDriver() {
        getDriver().quit();
        Log.error("WebDriver is successfully quit");
    }
}
