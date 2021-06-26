package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class TotalAmountTest extends BaseTest {
    @Test
    public void testTotalAmount() {
        signInAndOutPageModel.signIntoAccount(ResourceBundle.getBundle("LoginCred").getString("username"), ResourceBundle.getBundle("LoginCred").getString("password"));
        searchPageModel.searchItem("short");
        searchPageModel.addSearchedItemToCart();
        searchPageModel.goToCart();
        String totalAmount = cartPageModel.getTotalPrice();
        cartPageModel.summaryProceedToCheckout();
        cartPageModel.addressTabProceedToCheckout();
        cartPageModel.checkTermsOfServiceCheckbox();
        cartPageModel.shippingTabProceedToCheckout();
        Assert.assertEquals(totalAmount, cartPageModel.getTotalPrice(), "Total amounts are different");

    }

}
