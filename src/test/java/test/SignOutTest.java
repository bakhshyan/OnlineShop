package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;

public class SignOutTest extends BaseTest {
    @Test
    public void testSignOut() {
        MyLogger.info("SignOutTest has been started");
        signInAndOutPage.signOut();
        Assert.assertEquals(signInAndOutPage.getTitle(), "Login - My Store", "You are not signed out");
    }
}
