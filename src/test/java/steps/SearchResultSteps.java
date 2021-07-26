package steps;

import baseEntities.BaseStep;

public class SearchResultSteps extends BaseStep {

    public void verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatExpectedValueIsContainInSearchList(text);
    }
}
