package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class JsExecutorUtil {
    private static WebDriver driver = BaseTest.getDriver();

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    public static void clickElementWithJSExecutor(WebElement element){
        executeScript("arguments[0].click()", element);
    }
}
