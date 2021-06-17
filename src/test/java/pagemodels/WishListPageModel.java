package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WishListPageModel {

    private WebDriver driver;
    private List<WebElement> addedWishListItems;

    @FindBy(css = "a[title='My wishlists']")
    private WebElement goToMyWishListsPage;

    @FindBy(id = "name")
    private WebElement myWishItemName;

    @FindBy(id = "submitWishlist")
    private WebElement wishItemSaveButton;



    public WishListPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addWishItem(String wishItemName) {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(goToMyWishListsPage)).click();
       // goToMyWishListsPage.click();
        myWishItemName.sendKeys(wishItemName);
        wishItemSaveButton.click();
    }

    public Boolean  checkedWishItemExists(String wishItem) {
        boolean isAddedWishItem = false;
        setAddedWishListItems();
       // addedWishListItems = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody")).findElements(By.tagName("tr"));
        for (WebElement a : addedWishListItems) {
            if (wishItem.equals(a.findElement(By.tagName("td")).findElement(By.tagName("a")).getText())) {
                isAddedWishItem = true;
            }
        }
        return  isAddedWishItem;
    }

    public int getWishListItemQuantiy() {
        setAddedWishListItems();
        return addedWishListItems.size();

    }

    private void setAddedWishListItems() {
        addedWishListItems=driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody")).findElements(By.tagName("tr"));
    }


}
