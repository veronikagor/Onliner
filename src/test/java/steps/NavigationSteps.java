package steps;

import pages.MainPage;
import pages.NewsPage;

public class NavigationSteps {
    private MainPage mainPage;
    private NewsPage newsPage;

    public NavigationSteps() {
        this.mainPage = new MainPage();
        this.newsPage = new NewsPage();
    }

    public NavigationSteps moveToNavigationLinkTooltip(String linkName) {
        mainPage.moveToNavigationLink(linkName);
        return this;
    }

    public NavigationSteps verifyThatMenuItemIsPresent(String menuItem) {
        mainPage.assertThatMenuItemsIsPresent(menuItem);
        return this;
    }

    public NavigationResultSteps clickMenu(String menuItem) {
        mainPage.clickMenuItem(menuItem);
        return new NavigationResultSteps();
    }

    public NavigationResultSteps clickNews() {
        newsPage.clickTheFirstNews();
        return new NavigationResultSteps();
    }
}
