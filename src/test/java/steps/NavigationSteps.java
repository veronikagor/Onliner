package steps;

import baseEntities.BaseStep;

public class NavigationSteps extends BaseStep {

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
