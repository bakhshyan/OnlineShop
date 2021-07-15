package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class StringUtils {
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
