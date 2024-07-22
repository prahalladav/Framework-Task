package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Summary {
    private WebDriver driver;
//    private WebDriverWait wait;

    public Summary(WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//span[@class='Kfvdz'])[10]")
    private WebElement actualNumberOfInstances;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[11]")
    private WebElement actualOperatingSystem;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[12]")
    private WebElement actualProvisioningModel;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[3]")
    private WebElement actualMachineType;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[16]")
    private WebElement actualGpuToggle;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[5]")
    private WebElement actualGpuType;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[6]")
    private WebElement actualNumberOfGpus;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[7]")
    private WebElement actualLocalSsd;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[18]")
    private WebElement actualRegion;

    @FindBy(xpath = "(//span[@class='Kfvdz'])[19]")
    private WebElement actualCommitedUse;

    public String getInstance() {
        return actualNumberOfInstances.getText();
    }
    public String getOs() {
        return actualOperatingSystem.getText();
    }
    public String getModel() {
        return actualProvisioningModel.getText();
    }
    public String getMachineType() {
        return actualMachineType.getText();
    }
    public String getGpuToggle() {
        return actualGpuToggle.getText();
    }
    public String getGpuType() {
        return  actualGpuType.getText();
    }
    public String getNoOfGpus() {
        return  actualNumberOfGpus.getText();
    }
    public String getSsd() {
        return  actualLocalSsd.getText();
    }
    public String getRegion() {
        return  actualRegion.getText();
    }
    public String getCommitedUse() {
        return   actualCommitedUse.getText();
    }


}
