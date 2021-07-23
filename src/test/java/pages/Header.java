package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class Header extends BasePage {

    @FindBy(className = "fast-search__input")
    public WebElement searchFieldElement;

    public Header() {
        super();
    }

    public void pasteToTheSearchField(String text) {
        WaitUtils.waitElementIsClickable(searchFieldElement);
        click(searchFieldElement);
        sendKeys(searchFieldElement, text);
        pressEnter(searchFieldElement);
    }
}
