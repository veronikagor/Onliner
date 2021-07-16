package utils.driverUtils;

import org.openqa.selenium.WebDriver;
import utils.PropertyReader;
import java.time.Duration;

public abstract class DriverManager {
    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }

        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyReader.getDefaultWebDriverWait()));
        drivers.get().manage().window().maximize();
        drivers.get().get(PropertyReader.getBaseUrl());

        return drivers.get();
    }

    public abstract WebDriver createDriver();
}
