package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driverUtils.DriverHelper;

import java.util.List;

public class WaitUtils {
    private static WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), PropertyReader.getDefaultWebDriverWait());

    public static void waitElementIsClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void waitElementIsVisible(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static void waitElementsAreVisible(List<WebElement> webElementList) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());//TODO exception
        }
    }
}
