package steps;

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

    public NavigationResultSteps clickMenu(String menuItem) {
        mainPage.clickMenuItem(menuItem);
        return new NavigationResultSteps();
    }

    public NavigationResultSteps clickNews() {
        newsPage.clickTheFirstNews();
        return new NavigationResultSteps();
    }
}
