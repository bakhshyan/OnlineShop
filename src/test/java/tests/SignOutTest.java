package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class SignOutTest extends BaseTest {
    @Test
    public void testSignOut() {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        signInAndOutPage.signOut();
        Assert.assertEquals(signInAndOutPage.getTitle(), "Login - My Store", "You are not signed out");
    }
}
