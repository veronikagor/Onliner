package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.NavigationSteps;
import steps.SearchSteps;
import utils.DriverManager;
import utils.PropertyReader;

public abstract class BaseTest {
    private WebDriver driver;
    protected NavigationSteps navigationStep;
    protected SearchSteps searchSteps;

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeClass
    public void setUp() {
        driver = new DriverManager().getDriver();
        navigationStep = new NavigationSteps(driver);
        searchSteps = new SearchSteps(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().to(PropertyReader.getBaseUrl());
    }
}
