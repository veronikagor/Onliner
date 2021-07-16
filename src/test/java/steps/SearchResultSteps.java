package steps;

import pages.SearchResultPage;

public class SearchResultSteps {
    private SearchResultPage searchResultPage;

    public SearchResultSteps() {
        this.searchResultPage = new SearchResultPage();
    }

    public void verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatExpectedValueIsContainInSearchList(text);
    }
}
