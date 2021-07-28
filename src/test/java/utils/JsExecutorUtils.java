package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.driverUtils.DriverManager;

public class JsExecutorUtils {

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, args);
    }

    public static void clickElementWithJSExecutor(WebElement element) {
        Log.info("Click element with Javascript executor");
        executeScript("arguments[0].click()", element);
    }
}
