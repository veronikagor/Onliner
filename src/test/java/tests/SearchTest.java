package tests;

import baseEntities.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchText")
    public Object[][] searchText() {
        return new Object[][]{
                {"Вентилятор"},
                {"Кофемашина"}};
    }

    @Test(dataProvider = "searchText", description ="this test validates that the results of searching by keyword in search field contain proper text")
    public void searchByKeywordAndResultShouldContainsCorrectText(String text) {
        searchSteps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText(text);
    }
}
