package steps;

import pages.NewsPage;

public class NavigationResultSteps {

    private NewsPage newsPage = new NewsPage();

    public void verifyThatThatSelectedMenuItemAreActive(String projectNavigationItem) {
        newsPage.assertThatSelectedMenuItemsAreActive(projectNavigationItem);
    }
}
