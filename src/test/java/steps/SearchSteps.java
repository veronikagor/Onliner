package steps;

import org.openqa.selenium.WebDriver;
import pages.Header;

public class SearchSteps {
    private WebDriver driver;
    private Header header;

    public SearchSteps(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
    }

    public SearchResultSteps executeSearchByKeyword(String keyword) {
        header.pasteToTheSearchField(keyword);
        header.pressEnter();
        return new SearchResultSteps(driver);
    }
}