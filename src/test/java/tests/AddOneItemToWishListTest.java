package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AddOneItemToWishListTest extends BaseTest {

    @Test
    public void testWishListAdd() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        String wishItem = "123";
        wishListPageModel.addWishItem(wishItem);
        Assert.assertTrue(wishListPageModel.checkedWishItemExists(wishItem), "Wish item is not added");

    }
}
