package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest extends BaseTest {
    Logger logger = LogManager.getLogger(SignInTest.class);

    @Test
    public void testSignIn() {
        logger.info("SignInTest has started");

        Assert.assertEquals(signInAndOutPage.getTitle(), "My account - My Store", "You are not logged in");
    }
}
