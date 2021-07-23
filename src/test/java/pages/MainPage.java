package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'b-main-navigation__dropdown b-main-navigation__dropdown_visible']//a[@class='b-main-navigation__dropdown-title-link']")
    public List<WebElement> navigationMenuElements;

    @FindBy(xpath = "//span[@class='b-main-navigation__text']")
    public List<WebElement> navigationLinksElements;

    public MainPage() {
        super();
    }

    public void moveToNavigationLink(String linkName) {
        WebElement itemOfNavigationMenu = getItemFromNavigationLinks(linkName);
        moveToElement(itemOfNavigationMenu);
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
        WaitUtils.waitElementsAreVisible(By.xpath("//div[@class = 'b-main-navigation__dropdown b-main-navigation__dropdown_visible']//a[@class='b-main-navigation__dropdown-title-link']"));
        return navigationMenuElements.stream()
                .filter(i -> i.getText().equalsIgnoreCase(menuItemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Menu item [%s] is not present in the navigation menu", menuItemName)));
    }

    public void assertThatMenuItemsIsPresent(String expectedMenuItemName) {
        WaitUtils.waitElementsAreVisible(By.xpath("//div[@class = 'b-main-navigation__dropdown b-main-navigation__dropdown_visible']//a[@class='b-main-navigation__dropdown-title-link']"));
        assertThat(navigationMenuElements.stream()
                .filter(i -> i.getText().equalsIgnoreCase(expectedMenuItemName))
                .count())
                .as("Expected menu item [" + expectedMenuItemName + "] was not found]")
                .isNotZero();
    }
}
