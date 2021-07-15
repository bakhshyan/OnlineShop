package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "a[title='My wishlists']")
    private WebElement goToMyWishListPage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WishListPage goToMyWishListPage() {
        waitForELementToAppear(goToMyWishListPage);
        goToMyWishListPage.click();
        return new WishListPage(driver);
    }

}
