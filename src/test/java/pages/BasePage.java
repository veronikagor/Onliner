package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ActionUtil;
import utils.JsExecutorUtil;
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
        ActionUtil.moveToElement(element);
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
            WaitUtils.getClickableElement(element).click();
        } catch (Exception e) {
            JsExecutorUtil.clickElementWithJSExecutor(element);
        }
    }
}
