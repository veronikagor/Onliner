package steps;

import org.openqa.selenium.WebDriver;
import pages.SearchResultPage;

public class SearchResultSteps {
    private WebDriver driver;
    private SearchResultPage searchResultPage;

    public SearchResultSteps(WebDriver driver) {
        this.driver = driver;
        this.searchResultPage = new SearchResultPage(driver);
    }

    public void verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatExpectedValueIsContainInSearchList(text);
    }
}
