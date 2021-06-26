package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AddManyItemsToWishListTest extends BaseTest {
    @BeforeClass
    public void signIn() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));

    }


    @Test(dataProvider = "wish-list-items")
    public void testAddManyItemsToWishList(String wishItem) {

        wishListPageModel.addWishItem(wishItem);

    }

    @DataProvider(name = "wish-list-items")
    public Object[][] wishListItems() {
        return new Object[][]{

                {"T-shirt"}, {"Jeans"}, {"Jacket"}
        };
    }
}
