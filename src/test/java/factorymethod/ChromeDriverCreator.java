package factorymethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements WebDriverCreator {


    @Override
    public WebDriver creatWebdriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
