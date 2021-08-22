package test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.MyLogger;


public class AddManyItemsToWishListTest extends BaseTest {

    @Test(dataProvider = "wish-list-items")
    public void testAddManyItemsToWishList(String wishItem) {
        MyLogger.info("AddManyItemsToWishListTest has been started");
        myAccountPage.goToMyWishListPage();
        wishListPage.addWishItem(wishItem);

    }

    @DataProvider(name = "wish-list-items")
    public Object[][] wishListItems() {
        return new Object[][]{

                {"T-shirt"}, {"Jeans"}, {"Jacket"}
        };
    }
}
