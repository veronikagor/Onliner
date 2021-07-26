package steps;

import baseEntities.BaseStep;

public class SearchSteps extends BaseStep {

    public SearchResultSteps executeSearchByKeyword(String keyword) {
        header.pasteToTheSearchField(keyword);
        return new SearchResultSteps();
    }
}