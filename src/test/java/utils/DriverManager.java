package utils;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;

    public DriverManager() {
        this.driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        this.driver.get(PropertyReader.getBaseUrl());
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver(){
        return this.driver;
    }

}
