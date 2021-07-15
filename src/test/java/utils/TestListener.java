package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;
import test.SignInTest;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    private Logger logger = LogManager.getLogger(SignInTest.class);

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot();

    }

    private void saveScreenShot() {
        File screenCapture = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" + getCurrentTime() + ".png"));
        } catch (IOException e) {
            logger.error("Failed to save the screenshot" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm_ss");
        return ZonedDateTime.now().format(formatter);
    }
}
