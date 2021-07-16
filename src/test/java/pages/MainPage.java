package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {
    private Header header;

    private By navigationMenu = By.xpath("//div[@class = 'b-main-navigation__dropdown b-main-navigation__dropdown_visible']//a[@class='b-main-navigation__dropdown-title-link']");
    private By navigationLinks = By.xpath("//span[@class='b-main-navigation__text']");

    public MainPage() {
        super();
        this.header = new Header();
    }

    public List<WebElement> navigationMenuElements() {
        return waitService.getVisibleElements(navigationMenu);
    }

    public List<WebElement> navigationLinksElements() {
        return waitService.getVisibleElements(navigationLinks);
    }

    public void moveToNavigationLink(String linkName) {
        WebElement itemOfNavigationMenu = getItemFromNavigationLinks(linkName);
        builder.moveToElement(itemOfNavigationMenu).build().perform();
    }

    public WebElement getItemFromNavigationLinks(String linkName) {
        return navigationLinksElements().stream()
                .filter(i -> i.getText().equalsIgnoreCase(linkName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Link name [%s] is not present in the navigation menu", linkName)));
    }

    public void clickMenuItem(String menuItemName) {
        WebElement navigationMenuItem = getMenuItem(menuItemName);
        click(navigationMenuItem);
    }

    public WebElement getMenuItem(String menuItemName) {
        return navigationMenuElements().stream()
                .filter(i -> i.getText().equalsIgnoreCase(menuItemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Menu item [%s] is not present in the navigation menu", menuItemName)));
    }

    public void assertThatMenuItemsIsPresent(String expectedMenuItemName) {
        assertThat(navigationMenuElements().stream()
                .filter(i -> i.getText().equalsIgnoreCase(expectedMenuItemName))
                .count())
                .as("Expected menu item [" + expectedMenuItemName + "] was not found]")
                .isNotZero();
    }
}
