package steps;

import pages.Header;

public class SearchSteps {
    private Header header = new Header();

    public SearchResultSteps executeSearchByKeyword(String keyword) {
        header.pasteToTheSearchField(keyword);
        header.pressEnter();
        return new SearchResultSteps();
    }
}