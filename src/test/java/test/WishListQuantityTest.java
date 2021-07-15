package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WishListQuantityTest extends BaseTest {
    private Logger logger = LogManager.getLogger(WishListQuantityTest.class);

    @Test(dataProvider = "wish-list-items")
    public void addWishList(String wishItem) {
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);

    }

    @Test
    public void testAddWishListQuantity() {
        logger.info("WishListQuantityTest has been started");
        Assert.assertEquals(wishListPage.getWishListItemQuantiy(), wishListItems().length, "Wish List Quantity is not correct");
    }

    @DataProvider(name = "wish-list-items")
    public Object[][] wishListItems() {
        return new Object[][]{

                {"T-shirt"}, {"Jeans"}
        };
    }
}
