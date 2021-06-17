package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pagemodels.SignInPageModel;
import pagemodels.WishListPageModel;

public class BaseTest {

    public WebDriver driver;
    public SignInPageModel signInPageModel;
    public WishListPageModel wishListPageModel;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

        signInPageModel = new SignInPageModel(driver);
        wishListPageModel = new WishListPageModel(driver);
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
