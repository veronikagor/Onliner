package steps;

import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.NewsPage;

public class NavigationStep {

    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    public NavigationStep moveToNavigationLinkTooltip(String linkName) {
        mainPage.moveToNavigationLink(linkName);
        return this;
    }

    public NavigationStep verifyThatMenuItemIsPresent(String menuItem) {
        mainPage.assertThatMenuItemsIsPresent(menuItem);
        return this;
    }

    public NavigationResultSteps clickMenuItem(String menuItem) {
        WebElement menuItemElement = mainPage.getItemFromNavigationMenu(menuItem);
        mainPage.click(menuItemElement);
        return new NavigationResultSteps();
    }

    public NavigationResultSteps clickTheFirstNews() {
        WebElement firstNews = newsPage.getTheFirstCoupleOfNews();
        newsPage.click(firstNews);
        return new NavigationResultSteps();
    }
}
