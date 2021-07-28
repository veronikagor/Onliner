package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.driverUtils.DriverManager;

public class ActionUtils {
    private static Actions actions = new Actions(DriverManager.getDriver());

    public static void moveToElement(WebElement element) {
        Log.info("The mouse cursor moves to an element");
        actions.moveToElement(element).build().perform();
    }
}
