package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ActionUtils;
import utils.JsExecutorUtils;
import utils.WaitUtils;
import utils.driverUtils.DriverHelper;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverHelper.getDriver();
    }

    public void moveToElement(WebElement element) {
        ActionUtils.moveToElement(element);
    }

    public void click(WebElement element) {
        try {
            WaitUtils.waitElementIsClickable(element);
            element.click();
        } catch (Exception e) {
            JsExecutorUtils.clickElementWithJSExecutor(element);
        }
    }
}
