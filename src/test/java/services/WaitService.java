package services;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.util.List;

public class WaitService {
    private WebDriverWait wait;

    public WaitService(WebDriver driver) {
        this.wait = new WebDriverWait(driver, PropertyReader.getDefaultWebDriverWait());
    }

    public WebElement getClickableElement(WebElement webElement)
    {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }
        catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public WebElement getVisibleElement(By by)
    {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public List<WebElement> getVisibleElements(By by)
    {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }
        catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());//TODO exception
        }
    }
}
