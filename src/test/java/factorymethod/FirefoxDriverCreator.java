package factorymethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements WebDriverCreator {


    @Override
    public WebDriver creatWebdriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}
