package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    Header header;

    private By searchResultRow = By.xpath("//div[@class ='result__item result__item_product']//a[@class='product__title-link']");
    private By searchIframe = By.className("modal-iframe");

    public SearchResultPage() {
        super();
        this.header = new Header();
    }

    public void assertThatExpectedValueIsContainInSearchList(String expectedValue) {
        driver.switchTo().frame(driver.findElement(searchIframe));
        List<WebElement> searchResultURLsElements = driver.findElements(searchResultRow);

        assertThat(searchResultURLsElements.stream().map(WebElement::getText).collect(Collectors.toList()).toString())
                .as("This result does not contain " + expectedValue)
                .containsIgnoringCase(expectedValue);
    }
}

