package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    private WebDriver driver;
    private List<WebElement> addedWishListItems;

    @FindBy(css = "a[title='My wishlists']")
    private WebElement goToMyWishListsPage;

    @FindBy(id = "name")
    private WebElement myWishItemName;

    @FindBy(id = "submitWishlist")
    private WebElement wishItemSaveButton;


    public WishListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void addWishItem(String wishItemName) {
        waitForELementToAppear(goToMyWishListsPage);
        goToMyWishListsPage.click();
        myWishItemName.sendKeys(wishItemName);
        wishItemSaveButton.click();
    }

    public Boolean checkedWishItemExists(String wishItem) {
        boolean isAddedWishItem = false;
        setAddedWishListItems();
        for (WebElement a : addedWishListItems) {
            if (wishItem.equals(a.findElement(By.tagName("td")).findElement(By.tagName("a")).getText())) {
                isAddedWishItem = true;
            }
        }
        return isAddedWishItem;
    }

    public int getWishListItemQuantiy() {
        setAddedWishListItems();
        return addedWishListItems.size();

    }

    private void setAddedWishListItems() {
        addedWishListItems = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody")).findElements(By.tagName("tr"));
    }


}
