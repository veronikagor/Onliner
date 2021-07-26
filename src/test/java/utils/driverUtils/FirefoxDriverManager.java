package utils.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.Log;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public WebDriver createDriver() {
        Log.info("Initializing Firefox Driver");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        var mimeTypes =
                "image/png,image/gif,image/jpeg,image/pjpeg,application/pdf,text/csv,application/vnd.ms-excel," +
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" +
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

        var firefoxOptions = new FirefoxOptions();
        var profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", mimeTypes);
        profile.setPreference("browser.helperApps.neverAsk.openFile", mimeTypes);

        return firefoxOptions;
    }
}
