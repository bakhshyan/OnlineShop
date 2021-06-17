package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddOneItemToWishListTest extends BaseTest {

    @Test
    public void testWishListAdd() {
        String wishItem = "123";
        signInPageModel.signIntoAccount("hayk@mail.ru","Qwerty12@");
        wishListPageModel.addWishItem(wishItem);
        Assert.assertTrue(wishListPageModel.checkedWishItemExists(wishItem),"Wish item is not added");

    }
}
