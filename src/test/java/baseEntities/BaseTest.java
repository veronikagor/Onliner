package baseEntities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.NavigationSteps;
import steps.SearchSteps;
import utils.Log;
import utils.PropertyReader;
import utils.driverUtils.DriverManager;

public abstract class BaseTest {
    protected NavigationSteps navigationStep = new NavigationSteps();
    protected SearchSteps searchSteps = new SearchSteps();

    @BeforeClass
    public void setUp() {
        Log.startTestCase();
        DriverManager.goToUrl(PropertyReader.getBaseUrl());
    }

    @AfterMethod
    public void goBack() {
        DriverManager.goToUrl(PropertyReader.getBaseUrl());
    }

    @AfterClass
    public void tearDown() {
        Log.endTestCase();
        DriverManager.quitDriver();
    }
}
