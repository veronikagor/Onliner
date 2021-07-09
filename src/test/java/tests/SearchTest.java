package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchText")
    public Object[][] searchText() {
        return new Object[][]{{"Вентилятор"}, {"Кофемашина"}};
    }

    @Test(dataProvider = "searchText")
    public void searchByKeyword_resultShouldContainsCorrectText(String text) {

        searchSteps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText(text);
    }
}
