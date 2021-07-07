package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.NavigationSteps;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;

import java.time.Duration;

public abstract class BaseTest {

    private static WebDriver driver;
    NavigationSteps navigationStep;
    SearchSteps searchSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getBaseUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigationStep = new NavigationSteps();
        searchSteps = new SearchSteps();
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
