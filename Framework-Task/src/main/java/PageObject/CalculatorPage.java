package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;
    private Actions act;
    private WebDriverWait wait;
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.act = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='wX4xVc-Bz112c-RLmnJb'])[2]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[4]")
    private WebElement os;

    @FindBy(xpath = "//li[@data-708c49e2-dcf0-4d62-b457-88577bfe3081='Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)']")
    private WebElement osDropdown;

    @FindBy(xpath = "//label[text()='Regular']")
    private WebElement model;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[5]")
    private WebElement machineFamily;

    @FindBy(xpath = "//li[@data-value=\"general-purpose\"]")
    private WebElement machineFamilyDropdown;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[6]")
    private WebElement series;

    @FindBy(xpath = "//li[@data-708c49e2-dcf0-4d62-b457-88577bfe3081='N1']")
    private WebElement seriesDropdown;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[7]")
    private WebElement machineType;

    @FindBy(xpath = "//li[@data-value=\"n1-standard-8\"]")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "(//span[@class='eBlXUe-hywKDc'])[6]")
    private WebElement selecting;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[8]")
    private WebElement gpuModel;

    @FindBy(xpath = "//li[@data-value=\"nvidia-tesla-v100\"]")
    private WebElement gpuModelDropdown;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[9]")
    private WebElement numberOfGpus;

    @FindBy(xpath = "(//li[@data-value=\"1\"])[1]")
    private WebElement numberOfGpuDropdown;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[10]")
    private WebElement localSd;

    @FindBy(xpath = "(//li[@data-value=\"2\"])[2]")
    private WebElement localSdDropdown;

    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[11]")
    private WebElement region;

    @FindBy(xpath = "//li[@data-value='europe-west4']")
    private WebElement regionDropdown;

    @FindBy(xpath = "//label[normalize-space()='1 year']")
    private WebElement discount;

    @FindBy(xpath = "//span[@class='FOBRw-vQzf8d']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[normalize-space()='Open estimate summary']")
    private WebElement openEstimate;
    public void fillOutForm() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.visibilityOf(numberOfInstances)).click();
        }
        os.click();
        act.moveToElement(osDropdown).click().perform();
        model.click();
        machineFamily.click();
        act.moveToElement(machineFamilyDropdown).click().perform();
        series.click();
        act.moveToElement(seriesDropdown).click().perform();
        machineType.click();
        //act.moveToElement(machineTypeDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOf(machineTypeDropdown)).click();
        selecting.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Service cost updated']")));
        gpuModel.click();
        wait.until(ExpectedConditions.visibilityOf(gpuModelDropdown)).click();
        numberOfGpus.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfGpuDropdown)).click();
        localSd.click();
        wait.until(ExpectedConditions.visibilityOf(localSdDropdown)).click();
        region.click();
        wait.until(ExpectedConditions.visibilityOf(regionDropdown)).click();
        wait.until(ExpectedConditions.visibilityOf(discount)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Service cost updated']")));
        wait.until(ExpectedConditions.visibilityOf(shareButton)).click();
    }

    public void clickopenEstimate() {
        wait.until(ExpectedConditions.visibilityOf(openEstimate)).click();
    }
}