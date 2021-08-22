package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;
import utils.StringUtils;

import java.util.List;

public class AddToCardTest extends BaseTest {

    @Test
    public void testAddToCart() {
        MyLogger.info("AddToCardTest has been started");
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        List<String> addedItemsNames = searchPage.getAddedItemNames();
        searchPage.goToCart();
        Assert.assertTrue(new StringUtils().compare(addedItemsNames, cartPage.cardItemsNames()));

    }
}
