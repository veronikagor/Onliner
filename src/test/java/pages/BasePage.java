package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import services.WaitService;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitService waitService;
    protected Actions builder;
    protected JavascriptExecutor executor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitService = new WaitService(this.driver);
        this.builder = new Actions(this.driver);
        this.executor = (JavascriptExecutor) this.driver;
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
            waitService.getClickableElement(element).click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click()", element);
        }
    }
}
