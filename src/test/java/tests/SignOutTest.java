package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class SignOutTest extends BaseTest {
    @Test
    public void testSignOut() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        signInAndOutPageModel.signOut();
        Assert.assertEquals(signInAndOutPageModel.getTitle(), "Login - My Store", "You are not signed out");
    }
}
