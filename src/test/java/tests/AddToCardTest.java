package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ResourceBundle;

public class AddToCardTest extends BaseTest {

    @Test
    public void testAddToCart() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        searchPageModel.searchItem("short");
        searchPageModel.addSearchedItemToCart();
        List<String> addedItemsNames = searchPageModel.getAddedItemNames();
        searchPageModel.goToCart();
        Assert.assertTrue(cartPageModel.compare(addedItemsNames, cartPageModel.cardItemsNames()));

    }
}
