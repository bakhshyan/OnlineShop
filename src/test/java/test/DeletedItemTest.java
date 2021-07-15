package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletedItemTest extends BaseTest {
    private Logger logger = LogManager.getLogger(DeletedItemTest.class);

    @Test
    public void testItemDeletesFromCart() {
        logger.info("DeletedItemTest has been started");
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        searchPage.goToCart();
        cartPage.deleteItem();
        Assert.assertFalse(cartPage.cardItemsNames().contains(cartPage.deletedCardItemName()));
    }
}
