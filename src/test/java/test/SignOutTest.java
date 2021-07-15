package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends BaseTest {
    private Logger logger = LogManager.getLogger(SignOutTest.class);

    @Test
    public void testSignOut() {
        logger.info("SignOutTest has been started");
        signInAndOutPage.signOut();
        Assert.assertEquals(signInAndOutPage.getTitle(), "Login - My Store", "You are not signed out");
    }
}
