package pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPageModel extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[@class='cart_description']/p[@class='product-name']/a")
    private List<WebElement> cardItemsNames;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[@class='cart_delete text-center']/div/a")
    private WebElement deleteItemIcon;

    @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[@class='cart_delete text-center']/div/a")
    private WebElement deletedItemName;

    @FindBy(id = "total_price")
    private WebElement totalPrice;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    private WebElement summaryTabProceedToCheckoutButton;

    @FindBy(name = "processAddress")
    private WebElement addressTabProceedToCheckoutButton;

    @FindBy(name = "processCarrier")
    private WebElement shippingTabProceedToCheckoutButton;

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;

    public CartPageModel(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void deleteItem() {
        deleteItemIcon.click();
    }

    public List<WebElement> cardItemsNames() {
        return cardItemsNames;
    }

    public String deletedCardItemName() {
        return deletedItemName.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void summaryProceedToCheckout() {
        summaryTabProceedToCheckoutButton.click();

    }

    public void checkTermsOfServiceCheckbox() {
        scrollIntoElement(termsOfServiceCheckbox);
        termsOfServiceCheckbox.click();

    }

    public void addressTabProceedToCheckout() {
        waitForELementToAppear(addressTabProceedToCheckoutButton);
        addressTabProceedToCheckoutButton.click();
    }

    public void shippingTabProceedToCheckout() {
        waitForELementToAppear(shippingTabProceedToCheckoutButton);
        shippingTabProceedToCheckoutButton.click();
    }

    public boolean compare(List<String> addedItemName, List<WebElement> cardItemsNames) {
        boolean result = false;
        for (int i = 0; i < cardItemsNames.size(); i++) {
            for (int j = 0; j < addedItemName.size(); j++) {
                if (addedItemName.get(j).equals(cardItemsNames.get(i).getText())) {
                    result = true;
                }
            }
        }
        return result;
    }
}
