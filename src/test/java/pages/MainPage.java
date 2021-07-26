package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ActionUtils;
import utils.WaitUtils;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'b-main-navigation__dropdown b-main-navigation__dropdown_visible']//a[@class='b-main-navigation__dropdown-title-link']")
    public List<WebElement> navigationMenuElements;

    @FindBy(xpath = "//span[@class='b-main-navigation__text']")
    public List<WebElement> navigationLinksElements;

    public void moveToNavigationLink(String linkName) {
        WebElement itemOfNavigationMenu = getItemFromNavigationLinks(linkName);
        ActionUtils.moveToElement(itemOfNavigationMenu);
    }

    public WebElement getItemFromNavigationLinks(String linkName) {
        return navigationLinksElements.stream()
                .filter(i -> i.getText().equalsIgnoreCase(linkName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Link name [%s] is not present in the navigation menu", linkName)));
    }

    public void clickMenuItem(String menuItemName) {
        WebElement navigationMenuItem = getMenuItem(menuItemName);
        click(navigationMenuItem);
    }

    public WebElement getMenuItem(String menuItemName) {
        WaitUtils.waitElementsAreVisible(navigationMenuElements);
        return navigationMenuElements.stream()
                .filter(i -> i.getText().equalsIgnoreCase(menuItemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Menu item [%s] is not present in the navigation menu", menuItemName)));
    }

    public void assertThatMenuItemsIsPresent(String expectedMenuItemName) {
        WaitUtils.waitElementsAreVisible(navigationMenuElements);
        Stream<WebElement> menuItemName = navigationMenuElements.stream().filter(i -> i.getText().equalsIgnoreCase(expectedMenuItemName));

        assertThat(menuItemName.count())
                .as(String.format("Expected menu item [%s] was not found]", expectedMenuItemName))
                .isNotZero();
    }
}
