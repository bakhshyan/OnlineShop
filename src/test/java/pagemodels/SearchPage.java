package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(className = "product_list grid row")
    private WebElement productList;

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> searchedItems;

    @FindBy(className = "lighter")
    private WebElement lighter;

    @FindBy(xpath = "//div[@class='shopping_cart']/a[@title='View my shopping cart']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closePopWindowIcon;

    @FindBy(xpath = "//ul[@class='product_list grid row']")
    private WebElement productListGrid;

    String addedToCardItemName = "//ul[@class='product_list grid row']/li[%s]//h5[@itemprop='name']/a[@class='product-name']";
    String addtoCardButton = ("//ul[@class='product_list grid row']/li[%s]/div[@class='product-container']/div[@class='right-block']/div[@class='button-container']/a[@title='Add to cart']");

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void setSearchInput(String searchItem) {
        waitForELementToAppear(searchInput);
        searchInput.sendKeys(searchItem);
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public void searchItem(String searchItem) {
        setSearchInput(searchItem);
        searchButtonClick();
    }

    private List<String> cartAddedItemsNames;

    public void addSearchedItemToCart() {
        waitForELementToAppear(productListGrid);
        cartAddedItemsNames = new ArrayList<>();
        for (int i = 0; i < searchedItems.size(); i++) {
            scrollIntoElement(searchedItems.get(i));
            Actions actions = new Actions(driver);
            actions.moveToElement(searchedItems.get(i)).perform();
            waitForELementToAppear(searchedItems.get(i));
            waitForELementToAppear(driver.findElement(By.xpath(String.format(addtoCardButton, i + 1))));
            driver.findElement(By.xpath(String.format(addtoCardButton, i + 1))).click();
            closePopWindow();
            cartAddedItemsNames.add(driver.findElement(By.xpath(String.format(addedToCardItemName, i + 1))).getText());
        }
    }

    public List<String> getAddedItemNames() {
        return cartAddedItemsNames;
    }

    public void goToCart() {
        goToCartButton.click();

    }

    public void closePopWindow() {
        waitForELementToAppear(closePopWindowIcon);
        closePopWindowIcon.click();
    }
}


