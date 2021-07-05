package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ResourceBundle;

public class AddToCardTest extends BaseTest {

    @Test
    public void testAddToCart() {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        List<String> addedItemsNames = searchPage.getAddedItemNames();
        searchPage.goToCart();
        Assert.assertTrue(cartPage.compare(addedItemsNames, cartPage.cardItemsNames()));

    }
}
