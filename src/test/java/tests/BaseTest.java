package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pagemodels.*;

public class BaseTest {

    public WebDriver driver;
    public SignInAndOutPage signInAndOutPage;
    public WishListPage wishListPage;
    public SearchPage searchPage;
    public CartPage cartPage;
    public MyAccountPage myAccountPage;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

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
