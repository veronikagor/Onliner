package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.NavigationSteps;
import steps.SearchSteps;
import utils.Log;
import utils.PropertyReader;
import utils.driverUtils.DriverHelper;

public abstract class BaseTest {
    private static WebDriver driver;
    protected NavigationSteps navigationStep;
    protected SearchSteps searchSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        Log.startTestCase();
        driver = DriverHelper.getDriver();
        navigationStep = new NavigationSteps();
        searchSteps = new SearchSteps();
    }

    @AfterMethod
    public void goBack() {
       DriverHelper.goToUrl(PropertyReader.getBaseUrl());

    }
    @AfterClass
    public void tearDown() {
        Log.endTestCase();
        DriverHelper.quitDriver();
    }
}
