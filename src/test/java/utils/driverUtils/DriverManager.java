package utils.driverUtils;

import org.openqa.selenium.WebDriver;
import utils.Log;
import utils.PropertyReader;

public class DriverManager {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (drivers.get() == null) {
            setDriver();
        }
        return drivers.get();
    }

    public static void setDriver() {
        drivers.set(DriverFactory.getDriver(PropertyReader.getBrowser()));
    }

    public static void goToUrl(String url) {
        Log.info("Go to " + url);
        drivers.get().get(url);
    }

    public static void quitDriver() {
        Log.info("WebDriver is successfully quit");
        drivers.get().quit();
        drivers.remove();
    }

    public static void closeDriver() {
        Log.info("WebDriver is successfully close");
        drivers.get().close();
    }
}