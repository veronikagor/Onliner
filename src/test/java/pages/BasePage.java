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

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WaitService waitService;
    Actions builder;
    JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        waitService = new WaitService(driver);
        builder = new Actions(driver);
        executor = (JavascriptExecutor) driver;
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
