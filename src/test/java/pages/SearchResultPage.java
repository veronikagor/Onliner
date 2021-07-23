package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class ='result__item result__item_product']//a[@class='product__title-link']")
    public List<WebElement> searchResultsRow;

    @FindBy(className = "modal-iframe")
    public WebElement searchIframe;

    public void assertThatExpectedValueIsContainInSearchList(String expectedValue) {
        driver.switchTo().frame(searchIframe);
        WaitUtils.waitElementsAreVisible(searchResultsRow);
        String actualValue = searchResultsRow.stream().map(WebElement::getText).collect(Collectors.toList()).toString();

        assertThat(actualValue)
                .as("This result does not contain " + expectedValue)
                .containsIgnoringCase(expectedValue);
    }
}

