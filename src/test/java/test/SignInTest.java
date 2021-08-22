package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;


public class SignInTest extends BaseTest {

    @Test
    public void testSignIn() {
        MyLogger.info("SignInTest has started");
        Assert.assertEquals(signInAndOutPage.getTitle(), "My account - My Store", "You are not logged in");
    }
}
