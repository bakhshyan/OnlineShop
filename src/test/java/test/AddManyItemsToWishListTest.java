package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddManyItemsToWishListTest extends BaseTest {
    private Logger logger = LogManager.getLogger(AddManyItemsToWishListTest.class);

    @Test(dataProvider = "wish-list-items")
    public void testAddManyItemsToWishList(String wishItem) {
        logger.info("AddManyItemsToWishListTest has been started");
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
