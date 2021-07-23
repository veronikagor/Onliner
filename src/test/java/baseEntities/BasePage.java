package baseEntities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.JsExecutorUtils;
import utils.Log;
import utils.WaitUtils;
import utils.driverUtils.DriverHelper;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverHelper.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void click(WebElement element) {
        try {
            WaitUtils.waitElementIsClickable(element);
            Log.info("Click element");
            element.click();
        } catch (Exception e) {
            JsExecutorUtils.clickElementWithJSExecutor(element);
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            Log.info(String.format("Paste [%s]"));
            element.sendKeys(text);
        } catch (Exception e) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection stringSelection = new StringSelection(text);
            clipboard.setContents(stringSelection, null);
            element.sendKeys(Keys.CONTROL, "v");
        }
    }

    public void pressEnter(WebElement element) {
        Log.info("Press Enter");
        element.sendKeys((Keys.RETURN));
    }
}
