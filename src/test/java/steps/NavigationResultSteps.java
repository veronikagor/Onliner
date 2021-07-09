package steps;

import org.openqa.selenium.WebDriver;
import pages.NewsPage;

public class NavigationResultSteps {
    private WebDriver driver;
    private NewsPage newsPage;

    public NavigationResultSteps(WebDriver driver) {
        this.driver = driver;
        this.newsPage = new NewsPage(driver);
    }

    public void verifyThatThatSelectedMenuItemAreActive(String projectNavigationItem) {
        newsPage.assertThatSelectedMenuItemsAreActive(projectNavigationItem);
    }
}
