package utils.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.Log;
import utils.PropertyReader;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getDriver(BrowserType browser) {
        WebDriver driver;
        switch (browser) {
            case CHROME:
                Log.info("Initializing Chrome Driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case FIREFOX:
                Log.info("Initializing Firefox Driver");
                WebDriverManager.firefoxdriver().setup();
                new FirefoxDriver(getFirefoxOptions());
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                throw new IllegalArgumentException(String.format("There are no assigned behaviour for retrieving driver for [%s] browser ", browser));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyReader.getDefaultWebDriverWait()));
        driver.manage().window().maximize();

        return driver;
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
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
