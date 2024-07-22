package tests;

import PageObject.CalculatorPage;
import PageObject.HomePage;
import PageObject.Summary;
import Utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;

public class CalculatorTest {

    private WebDriver driver;
    private HomePage task;
    private CalculatorPage task2;
    private Summary task3;

    @BeforeClass
    public  void  setup(){
        driver=new ChromeDriver();
        task=new HomePage(driver);
        task2=new CalculatorPage(driver);
        task3=new Summary(driver);
        driver.get("https://cloud.google.com/products/calculator");
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    public void testCostEstimate() throws InterruptedException {
        task.clickAddtoEstimate();
        task.clickComputeEngine();
        task2.fillOutForm();
        task2.clickopenEstimate();


    }
    @Test(priority = 2)
    public void checkingAsserts() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String instance = task3.getInstance();
        String os = task3.getOs();
        String model = task3.getModel();
        String machineType = task3.getMachineType();
        String gpuToggle = task3.getGpuToggle();
        String gpuType = task3.getGpuType();
        String noOfGpus = task3.getNoOfGpus();
        String ssd = task3.getSsd();
        String region = task3.getRegion();
        String dis = task3.getCommitedUse();
        SoftAssert ss=new SoftAssert();

// checking number of instances

        String expectedNumberOfInstances = "4";
        ss.assertEquals(expectedNumberOfInstances, instance);

// checking number of instances

        String expectedOperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        ss.assertEquals(expectedOperatingSystem, os);


// checking provisioning model

        String expectedProvisioningModel = "Regular";
        ss.assertEquals(expectedProvisioningModel, model);


// checking machine type

        String expectedMachineType = "n1-standard-8, vCPUs: 8, RAM: 30 GB";
        ss.assertEquals(expectedMachineType, machineType);

// checking Select GPU Toggle

        String expectedGpuToggle = "true";
        ss.assertEquals(expectedGpuToggle, gpuToggle);


// checking Gpu Type

        String expectedGpuType = "NVIDIA V100";
        ss.assertEquals(expectedGpuType, gpuType);


// checking Number of Gpus

        String expectedNumberOfGpus = "1";
        ss.assertEquals(expectedNumberOfGpus, noOfGpus);


// checking Local SSD

        String expectedLocalSsd = "2x375 GB";
        ss.assertEquals(expectedLocalSsd, ssd);


// checking Region

        String expectedRegion = "Netherlands (europe-west4)";
        ss.assertEquals(expectedRegion, region);


// checking Commited use discount options

        String expectedCommitedUse = "1 year";
        ss.assertEquals(expectedCommitedUse, dis);
        ss.assertAll();

    }

    @AfterClass
    public void tearDown() {
        ScreenshotUtil.takeScreenshot(driver);
        driver.quit();
    }
}
