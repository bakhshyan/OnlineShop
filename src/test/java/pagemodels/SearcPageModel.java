package pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearcPageModel {
    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButtonClick;

    @FindBy(className = "product_list grid row")
    private WebElement productList;
}


//ul[@class='product_list grid row']/li/div[@class='product-container']/div[@class='right-block']/div[@class='button-container']/a[@title='Add to cart']