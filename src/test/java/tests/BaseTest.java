package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pagemodels.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public WebDriver driver;
    public SignInAndOutPage signInAndOutPage;
    public WishListPage wishListPage;
    public SearchPage searchPage;
    public CartPage cartPage;
    public MyAccountPage myAccountPage;
    public String nodeUrl;

    @Parameters({"browserName"})
    @BeforeTest(alwaysRun = true)
    public void openBrowser(String browserName) throws MalformedURLException {
        //  System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        if (browserName.equals("chrome")) {
            nodeUrl = "http://192.168.224.1:4444/wd/hub";
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WINDOWS);

            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
            driver.get("http://automationpractice.com/");
            driver.manage().window().maximize();

        } else if (browserName.equals("firefox")) {


            nodeUrl = "http://192.168.224.1:4444/wd/hub";
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);

            driver = new RemoteWebDriver(new URL(nodeUrl), capability);
            driver.get("http://automationpractice.com/");
            driver.manage().window().maximize();
        }

        signInAndOutPage = new SignInAndOutPage(driver);
        wishListPage = new WishListPage(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
