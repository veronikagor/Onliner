package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsPage extends BasePage {
    private Header header;

    private By projectNavigationActiveItem = By.xpath("//li[@class='project-navigation__item project-navigation__item_primary project-navigation__item_active']");
    private By resultRowOfNews = By.xpath("//div[starts-with(@class, 'news-tidings__item news-tidings__item_1of3')]");

    public NewsPage() {
        super();
        this.header = new Header();
    }

    public List<WebElement> resultRowOfNews() {
         WaitUtils.waitElementsAreVisible(resultRowOfNews);
        return driver.findElements(resultRowOfNews);
    }

    public WebElement projectNavigationActiveItem() {
         WaitUtils.waitElementIsVisible(projectNavigationActiveItem);
        return driver.findElement(projectNavigationActiveItem);
    }

    public void assertThatSelectedMenuItemsAreActive(String expectedText) {
        assertThat(projectNavigationActiveItem().getText()
                .equalsIgnoreCase(expectedText))
                .as(String.format("The active project navigation item [%s] was not found or it's no active", expectedText));
    }

    public void clickTheFirstNews() {
        click(resultRowOfNews().get(0));
    }
}
