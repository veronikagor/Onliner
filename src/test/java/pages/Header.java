package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {

    private By searchField = By.className("fast-search__input");

    public Header() {
        super();
    }

    public WebElement searchFieldElement() {
        return waitService.getClickableElement(driver.findElement(searchField));
    }

    public void pasteToTheSearchField(String text) {
        pasteTextToElementFromClipboard(searchFieldElement(), text);
    }

    public void pressEnter() {
        searchFieldElement().sendKeys((Keys.RETURN));
    }
}
