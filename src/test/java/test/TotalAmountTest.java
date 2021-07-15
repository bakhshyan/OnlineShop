package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalAmountTest extends BaseTest {
    private Logger logger = LogManager.getLogger(TotalAmountTest.class);

    @Test
    public void testTotalAmount() {
        logger.info("TotalAmountTest has started");
        searchPage.searchItem("short");
        searchPage.addSearchedItemToCart();
        searchPage.goToCart();
        String totalAmount = cartPage.getTotalPrice();
        cartPage.summaryProceedToCheckout();
        cartPage.addressTabProceedToCheckout();
        cartPage.checkTermsOfServiceCheckbox();
        cartPage.shippingTabProceedToCheckout();
        Assert.assertEquals(totalAmount, cartPage.getTotalPrice(), "Total amounts are different");

    }

}
