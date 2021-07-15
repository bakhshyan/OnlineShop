package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddOneItemToWishListTest extends BaseTest {
    private Logger logger = LogManager.getLogger(AddOneItemToWishListTest.class);

    @Test
    public void testWishListAdd() {
        logger.info("AddOneItemToWishListTest has been started");
        String wishItem = "123";
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);
        Assert.assertTrue(wishListPage.checkedWishItemExists(wishItem), "Wish item is not added");

    }
}
