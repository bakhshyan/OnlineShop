package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class TotalAmountTest extends BaseTest {
    @Test
    public void testTotalAmount() {
        signInAndOutPage.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
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
