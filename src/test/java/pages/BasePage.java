package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ActionUtils;
import utils.JsExecutorUtils;
import utils.WaitUtils;
import utils.driverUtils.DriverHelper;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = DriverHelper.getDriver();
    }

    public void moveToElement(WebElement element) {
        ActionUtils.moveToElement(element);
    }

    public void pasteTextToElementFromClipboard(WebElement element, String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
        element.sendKeys(Keys.CONTROL, "v");
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
