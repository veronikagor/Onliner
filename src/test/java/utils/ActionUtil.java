package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

public class ActionUtil {
    private static WebDriver driver = BaseTest.getDriver();
    private static Actions builder = new Actions(driver);

    public static void moveToElement(WebElement element) {
        builder.moveToElement(element).build().perform();
    }
}
