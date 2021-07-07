package steps;

import pages.SearchResultPage;

public class SearchResultSteps {
    private SearchResultPage searchResultPage = new SearchResultPage();

    public void verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatExpectedValueIsContainInSearchList(text);
    }

}
