package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[starts-with(@class,'news-tidings__item news-tidings__item_1of3')]")
    public List<WebElement> resultRowOfNews;

    @FindBy(xpath = "//li[@class='project-navigation__item project-navigation__item_primary project-navigation__item_active']")
    public WebElement projectNavigationActiveItem;

    public NewsPage() {
        super();
    }

    public void assertThatSelectedMenuItemsAreActive(String expectedText) {
        WaitUtils.waitElementIsVisible(By.xpath("//li[@class='project-navigation__item project-navigation__item_primary project-navigation__item_active']"));
        assertThat(projectNavigationActiveItem.getText()
                .equalsIgnoreCase(expectedText))
                .as(String.format("The active project navigation item [%s] was not found or it's no active", expectedText));
    }

    public void clickTheFirstNews() {
        WaitUtils.waitElementsAreVisible(By.xpath("//div[starts-with(@class, 'news-tidings__item news-tidings__item_1of3')]"));
        click(resultRowOfNews.get(0));
    }
}
