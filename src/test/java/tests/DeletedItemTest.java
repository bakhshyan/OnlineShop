package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class DeletedItemTest extends BaseTest {

    @Test
    public void testItemDeletesFromCart() throws InterruptedException {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        searchPage.goToCart();
        cartPage.deleteItem();
        Assert.assertFalse(cartPage.cardItemsNames().contains(cartPage.deletedCardItemName()));
    }
}
