package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;

public class AddOneItemToWishListTest extends BaseTest {

    @Test
    public void testWishListAdd() {
        MyLogger.info("AddOneItemToWishListTest has been started");
        String wishItem = "123";
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);
        Assert.assertTrue(wishListPage.checkedWishItemExists(wishItem), "Wish item is not added");

    }
}
