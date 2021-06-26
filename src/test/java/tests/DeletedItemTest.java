package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class DeletedItemTest extends BaseTest {

    @Test
    public void testItemDeletesFromCart() throws InterruptedException {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        searchPageModel.searchItem("short");
        searchPageModel.addSearchedItemToCart();
        searchPageModel.goToCart();
        cartPageModel.deleteItem();
        Assert.assertFalse(cartPageModel.cardItemsNames().contains(cartPageModel.deletedCardItemName()));
    }
}
