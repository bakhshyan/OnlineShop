package pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInAndOutPageModel extends BasePage {
    private WebDriver driver;

    @FindBy(css = "a[title='Log in to your customer account']")
    private WebElement goToSignPage;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@title='Log me out']")
    private WebElement signOutButton;

    public SignInAndOutPageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void signIntoAccount(String email, String password) {
        waitForELementToAppear(goToSignPage);
        goToSignPage.click();
        waitForELementToAppear(this.email);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signInButton.click();
    }

    public void signOut() {
        waitForELementToAppear(signOutButton);
        signOutButton.click();
    }


}
