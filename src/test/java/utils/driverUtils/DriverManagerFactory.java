package utils.driverUtils;

import utils.Log;
import java.io.File;

public class DriverManagerFactory {
    private static final String DRIVER_PATH = "src/test/resources/";

    public static DriverManager getManager(BrowserType browser) {
        DriverManager driverManager;
        File file;
        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driverManager = new ChromeDriverManager();
                Log.info("New ChromeDriver instantiated");
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH + "IEDriverserver.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driverManager = new FirefoxDriverManager();
                Log.info("New FirefoxDriver instantiated");
                break;
            default:
               throw new IllegalArgumentException("There are no assigned behaviour for retrieving driver for browser " + browser);
        }
        return driverManager;
    }
}
