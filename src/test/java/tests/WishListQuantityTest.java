package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class WishListQuantityTest extends BaseTest {
    @BeforeClass()
    public void signIn() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
    }

    @Test(dataProvider = "wish-list-items")
    public void addWishList(String wishItem) {
        wishListPageModel.addWishItem(wishItem);

    }

    @Test
    public void testAddWishListQuantity() {
        Assert.assertEquals(wishListPageModel.getWishListItemQuantiy(), wishListItems().length, "Wish List Quantity is not correct");
    }

    @DataProvider(name = "wish-list-items")
    public Object[][] wishListItems() {
        return new Object[][]{

                {"T-shirt"}, {"Jeans"}
        };
    }
}
