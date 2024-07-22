package WebDriverManager;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private static WebDriver driver;

    private BrowserFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserInitializer.initializeBrowser();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
