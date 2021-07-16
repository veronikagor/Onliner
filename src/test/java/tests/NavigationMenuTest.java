package tests;

import constants.NavigationConstants;
import constants.TooltipNewsConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavigationMenuTest extends BaseTest {

    @DataProvider(name = "menuItemName")
    public Object[][] menuItemName() {
        return new Object[][]{
                {TooltipNewsConstants .PEOPLE},
                {TooltipNewsConstants .CARS},
                {TooltipNewsConstants .TECHNOLOGIES},
                {TooltipNewsConstants .REAL_ESTATE}
        };
    }

    @Test(dataProvider = "menuItemName")
    public void openNavigationLinkAndMenuItemsShouldBePresent(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationConstants.NEWS)
                .verifyThatMenuItemIsPresent(menuItemName);
    }

    @Test(dataProvider = "menuItemName")
    public void clickNavigationMenuItemAndSelectedItemShouldBeActive(String menuItemName) {
        navigationStep.moveToNavigationLinkTooltip(NavigationConstants .NEWS)
                .clickMenu(menuItemName)
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);

        navigationStep.clickNews()
                .verifyThatThatSelectedMenuItemAreActive(menuItemName);
    }
}
