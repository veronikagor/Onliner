package tests;

import constants.NavigationLinksConstants;
import constants.NewsMenuItemsConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavigationMenuTest extends BaseTest {

    @DataProvider(name = "menuItemName")
    public Object[][] menuItemName() {
        return new Object[][]{{NewsMenuItemsConstants.PEOPLE}, {NewsMenuItemsConstants.CARS}, {NewsMenuItemsConstants.TECHNOLOGIES}, {NewsMenuItemsConstants.REAL_ESTATE}};
    }

    @Test(dataProvider = "menuItemName")
    public void openNavigationLink_menuItemsShouldBePresent(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationLinksConstants.NEWS)
                .verifyThatMenuItemIsPresent(menuItemName);
    }

    @Test(dataProvider = "menuItemName")
    public void clickNavigationMenuItem_selectedItemShouldBeActive(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationLinksConstants.NEWS)
                .clickMenuItem(menuItemName)
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);

        navigationStep.clickTheFirstNews()
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);
    }
}
