package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver) {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        File destFile = new File("screenshots/" + now.format(formatter) + ".jpg");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
