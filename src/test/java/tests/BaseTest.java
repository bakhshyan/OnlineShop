package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pagemodels.CartPageModel;
import pagemodels.SearchPageModel;
import pagemodels.SignInAndOutPageModel;
import pagemodels.WishListPageModel;

public class BaseTest {

    public WebDriver driver;
    public SignInAndOutPageModel signInAndOutPageModel;
    public WishListPageModel wishListPageModel;
    public SearchPageModel searchPageModel;
    public CartPageModel cartPageModel;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();

        signInAndOutPageModel = new SignInAndOutPageModel(driver);
        wishListPageModel = new WishListPageModel(driver);
        searchPageModel = new SearchPageModel(driver);
        cartPageModel = new CartPageModel(driver);

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
