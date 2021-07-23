package steps;

import pages.Header;

public class SearchSteps {
    private Header header;

    public SearchSteps() {
        this.header = new Header();
    }

    public SearchResultSteps executeSearchByKeyword(String keyword) {
        header.pasteToTheSearchField(keyword);
        return new SearchResultSteps();
    }
}