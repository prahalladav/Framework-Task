package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Elements on the Calculator page
    @FindBy(xpath = "//span[text()='Add to estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//p[contains(text(),'A secure and customizable compute service that let')]")
    private WebElement computeEngine;

    // Methods to interact with elements on the page
    public void clickAddtoEstimate(){
        addToEstimateButton.click();
    }
    public void clickComputeEngine(){
        wait.until(ExpectedConditions.visibilityOf(computeEngine)).click();
    }

}
