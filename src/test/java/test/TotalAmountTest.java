package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.MyLogger;

public class TotalAmountTest extends BaseTest {

    @Test
    public void testTotalAmount() {
        MyLogger.info("TotalAmountTest has started");
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
