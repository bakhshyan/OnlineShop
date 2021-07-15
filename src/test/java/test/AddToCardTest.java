package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.StringUtils;

import java.util.List;

public class AddToCardTest extends BaseTest {
    private Logger logger = LogManager.getLogger(AddToCardTest.class);

    @Test
    public void testAddToCart() {
        logger.info("AddToCardTest has been started");
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        List<String> addedItemsNames = searchPage.getAddedItemNames();
        searchPage.goToCart();
        Assert.assertTrue(new StringUtils().compare(addedItemsNames, cartPage.cardItemsNames()));

    }
}
