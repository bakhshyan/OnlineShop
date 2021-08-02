package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSigleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocaldriver = new ThreadLocal<>();
    private static WebDriver driver;

    private DriverSigleton() {
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverThreadLocaldriver.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocaldriver.get();
    }

    public static void closeDriver() {
        driver.quit();
        webDriverThreadLocaldriver.remove();

    }

}
