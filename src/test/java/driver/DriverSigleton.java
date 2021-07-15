package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSigleton {
    private static WebDriver driver;

    private DriverSigleton() {
    }

    public static WebDriver getDriver(String browserName) {
        if (null == driver) {
            switch (browserName) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.get("http://automationpractice.com/");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
