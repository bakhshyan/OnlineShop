package test;

import driver.DriverSigleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import page.*;
import service.UserCreator;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    private Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public SignInAndOutPage signInAndOutPage;
    public WishListPage wishListPage;
    public SearchPage searchPage;
    public CartPage cartPage;
    public MyAccountPage myAccountPage;

    @Parameters({"browserName"})
    @BeforeTest(alwaysRun = true)
    public void openBrowser(String browserName) {
        logger.info("Browser is openning");
        driver = DriverSigleton.getDriver(browserName);
        signInAndOutPage = new SignInAndOutPage(driver);
        wishListPage = new WishListPage(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
        myAccountPage = new MyAccountPage(driver);

        signInAndOutPage.signIntoAccount(UserCreator.userWithCredentials());

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        logger.info("Browser is closing");
        DriverSigleton.closeDriver();
    }


}
