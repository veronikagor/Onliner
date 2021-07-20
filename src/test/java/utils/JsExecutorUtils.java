package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driverUtils.DriverHelper;

public class JsExecutorUtils {
    private static WebDriver driver = DriverHelper.getDriver();

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public static void clickElementWithJSExecutor(WebElement element){
        executeScript("arguments[0].click()", element);
    }
}
