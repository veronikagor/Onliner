package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.driverUtils.DriverHelper;

public class JsExecutorUtils {

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) DriverHelper.getDriver()).executeScript(script, args);
    }

    public static void clickElementWithJSExecutor(WebElement element){
        Log.info("Click element with Javascript executor");
        executeScript("arguments[0].click()", element);
    }
}
