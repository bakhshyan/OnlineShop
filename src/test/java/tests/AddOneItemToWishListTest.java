package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AddOneItemToWishListTest extends BaseTest {

    @Test
    public void testWishListAdd() {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        String wishItem = "123";
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);
        Assert.assertTrue(wishListPage.checkedWishItemExists(wishItem), "Wish item is not added");

    }
}
