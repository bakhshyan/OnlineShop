package pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPageModel {
    private WebDriver driver;

    @FindBy(css = "a[title='Log in to your customer account']")
    private WebElement goToSignPage;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public void signIntoAccount(String email, String password) {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(goToSignPage)).click();
        //goToSignPage.click();

        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
        //this.email.sendKeys(email);
        this.password.sendKeys(password);
        signInButton.click();
    }

    public SignInPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
