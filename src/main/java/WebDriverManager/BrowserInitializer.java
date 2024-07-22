package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utils.ConfigReader;

public class BrowserInitializer {
    private static ConfigReader configReader = new ConfigReader();

    public static WebDriver initializeBrowser() {
        WebDriver driver;
        String browser = configReader.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", configReader.getProperty("chromeDriverPath"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", configReader.getProperty("geckoDriverPath"));
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }

}
