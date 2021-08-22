package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;

public class DeletedItemTest extends BaseTest {

    @Test
    public void testItemDeletesFromCart() {
        MyLogger.info("DeletedItemTest has been started");
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        searchPage.goToCart();
        cartPage.deleteItem();
        Assert.assertFalse(cartPage.cardItemsNames().contains(cartPage.deletedCardItemName()));
    }
}
