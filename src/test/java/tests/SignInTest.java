package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SignInTest extends BaseTest {
    @Test
    public void testSignIn(){
        signInPageModel.signIntoAccount("hayk@mail.ru","Qwerty12@");
        Assert.assertEquals(driver.getTitle(),"My account - My Store","You are not logged in");
    }
}
