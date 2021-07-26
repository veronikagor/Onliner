package steps;

import baseEntities.BaseStep;

public class NavigationResultSteps extends BaseStep {

    public void verifyThatThatSelectedMenuItemAreActive(String projectNavigationItem) {
        newsPage.assertThatSelectedMenuItemsAreActive(projectNavigationItem);
    }
}
