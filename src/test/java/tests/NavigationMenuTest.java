package tests;

import baseEntities.BaseTest;
import constants.NavigationConstants;
import constants.TooltipNewsConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavigationMenuTest extends BaseTest {

    @DataProvider(name = "menuItemName")
    public Object[][] menuItemName() {
        return new Object[][]{
                {TooltipNewsConstants.PEOPLE},
                {TooltipNewsConstants.CARS},
                {TooltipNewsConstants.TECHNOLOGIES},
                {TooltipNewsConstants.REAL_ESTATE}
        };
    }

    @Test(dataProvider = "menuItemName", description = "this test validates that the additional menu of the news section is displayed")
    public void openNavigationLinkAndMenuItemsShouldBePresent(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationConstants.NEWS)
                .verifyThatMenuItemIsPresent(menuItemName);
    }

    @Test(dataProvider = "menuItemName", description = "this test validates that after selecting the additional menu item in the news section the selected tab is active")
    public void clickNavigationMenuItemAndSelectedItemShouldBeActive(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationConstants.NEWS)
                .clickMenu(menuItemName)
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);
    }

    @Test(dataProvider = "menuItemName", description = "this test validates that after selecting the first couple of news in the row the news tab is active")
    public void clickFirsCoupleOfNewsAndSelectedItemShouldBeActive(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationConstants.NEWS)
                .clickMenu(menuItemName);
        navigationStep.clickNews()
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);
    }
}
