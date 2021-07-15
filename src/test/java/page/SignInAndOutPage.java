package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInAndOutPage extends BasePage {
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

    public SignInAndOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void goToSignPage() {
        goToSignPage.click();
    }

    private void setEmail(String email) {
        waitForELementToAppear(this.email);
        this.email.sendKeys(email);
    }

    private void setPassword(String password) {
        this.password.sendKeys(password);
    }

    private void signInButtonClick() {
        signInButton.click();
    }

    public void signIntoAccount(User user) {
        goToSignPage();
        setEmail(user.getUsername());
        setPassword(user.getPassword());
        signInButtonClick();
    }

    public void signOut() {
        waitForELementToAppear(signOutButton);
        signOutButton.click();
    }


}
