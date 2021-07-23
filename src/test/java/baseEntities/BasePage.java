package baseEntities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.JsExecutorUtils;
import utils.WaitUtils;
import utils.driverUtils.DriverHelper;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverHelper.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void click(WebElement element) {
        try {
            WaitUtils.waitElementIsClickable(element);
            element.click();
        } catch (Exception e) {
            JsExecutorUtils.clickElementWithJSExecutor(element);
        }
    }

    public void pressEnter(WebElement element) {
       element.sendKeys((Keys.RETURN));
    }
}
