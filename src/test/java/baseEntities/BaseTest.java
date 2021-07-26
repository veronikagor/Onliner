package baseEntities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import steps.NavigationSteps;
import steps.SearchSteps;
import utils.Log;
import utils.PropertyReader;
import utils.driverUtils.DriverHelper;

public abstract class BaseTest {
    protected NavigationSteps navigationStep;
    protected SearchSteps searchSteps;

    @BeforeClass
    public void setUp() {
        Log.startTestCase();
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
