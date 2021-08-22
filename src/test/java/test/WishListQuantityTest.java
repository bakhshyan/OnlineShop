package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.MyLogger;

public class WishListQuantityTest extends BaseTest {

    @Test(dataProvider = "wish-list-items")
    public void addWishList(String wishItem) {
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);

    }

    @Test
    public void testAddWishListQuantity() {
        MyLogger.info("WishListQuantityTest has been started");
        Assert.assertEquals(wishListPage.getWishListItemQuantiy(), wishListItems().length, "Wish List Quantity is not correct");
    }

    @DataProvider(name = "wish-list-items")
    public Object[][] wishListItems() {
        return new Object[][]{

                {"T-shirt"}, {"Jeans"}
        };
    }
}
