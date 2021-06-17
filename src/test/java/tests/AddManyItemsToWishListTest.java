package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddManyItemsToWishListTest extends BaseTest {
    @BeforeClass
    public void signIn() {
        signInPageModel.signIntoAccount("hayk@mail.ru", "Qwerty12@");
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
