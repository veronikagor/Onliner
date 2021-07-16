package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driverUtils.DriverHelper;

import java.util.List;

public class WaitUtils {
    protected WebDriver driver;
    private static WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), PropertyReader.getDefaultWebDriverWait());

    public static WebElement getClickableElement(WebElement webElement) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static WebElement getVisibleElement(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static List<WebElement> getVisibleElements(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());//TODO exception
        }
    }
}
