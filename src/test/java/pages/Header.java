package pages;

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
        searchFieldElement.click();
        searchFieldElement.sendKeys(text);
        pressEnter(searchFieldElement);
    }
}
