package cucumber.hook;

import driver.DriverSigleton;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {
    public static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenshot(Scenario scenario) {
        scenario.write(DriverSigleton.getDriver().getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot) DriverSigleton.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, PNG_FILE_EXTENSION);
    }
}
