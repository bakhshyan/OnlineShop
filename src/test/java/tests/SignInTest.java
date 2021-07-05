package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class SignInTest extends BaseTest {
    @Test
    public void testSignIn() {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        Assert.assertEquals(signInAndOutPage.getTitle(), "My account - My Store", "You are not logged in");
    }
}
