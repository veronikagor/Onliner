package baseEntities;

import pages.Header;
import pages.MainPage;
import pages.NewsPage;
import pages.SearchResultPage;

public class BaseStep {
    protected MainPage mainPage;
    protected NewsPage newsPage;
    protected Header header;
    protected SearchResultPage searchResultPage;

    public BaseStep() {
        mainPage = new MainPage();
        newsPage = new NewsPage();
        header = new Header();
        searchResultPage = new SearchResultPage();
    }
}
