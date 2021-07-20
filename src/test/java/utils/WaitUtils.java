package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driverUtils.DriverHelper;

public class WaitUtils {
    private static WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), PropertyReader.getDefaultWebDriverWait());

    public static void waitElementIsClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void waitElementIsVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void waitElementsAreVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());//TODO exception
        }
    }
}
