package cucumber.steps;

import driver.DriverSigleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import page.SignInAndOutPage;
import service.UserCreator;

public class LoginSteps {
    SignInAndOutPage signInAndOutPage = new SignInAndOutPage(DriverSigleton.getDriver());

    @Given("the user open OnlineShop Website")
    public void theUserOpenOnlineShopWebsite() {
        DriverSigleton.getDriver().get("http://automationpractice.com/");
    }

    @When("the user click on the Sign in button")
    public void theUserClickOnTheSignInButton() {
        signInAndOutPage.goToSignPage();
    }

    @And("the user type the userName and password")
    public void theUserTypeTheUserNameAndPassword() {
        signInAndOutPage.setEmail(UserCreator.userWithCredentials().getUsername());
        signInAndOutPage.setPassword(UserCreator.userWithCredentials().getPassword());
        signInAndOutPage.signInButtonClick();

    }

    @Then("the user is signedIn")
    public void theUserIsSignedIn() {
        Assertions.assertThat(signInAndOutPage.getTitle()).isEqualTo("My account - My Store", "You are not logged in");
    }
}
